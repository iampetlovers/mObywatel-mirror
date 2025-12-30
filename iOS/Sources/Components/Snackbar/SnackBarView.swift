/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

struct SnackBarView: View {
  let item: Binding<SnackBar?>
  @Environment(\.sleep) private var sleep 

  var body: some View {
    if let item = self.item.wrappedValue {
      HStack(alignment: .top) {
        Text(item.title)
          .fixedSize(horizontal: false, vertical: true)
          .foregroundStyle(Color.white)
          .font(.footnote)
          .accessibilityIdentifier(.snackbarTitle)

        Spacer()

        if item.duration == nil {
          Button {
            self.item.wrappedValue = nil
          } label: {
            Icons.Outline.Navigation.xmark
              .resizable()
              .aspectRatio(contentMode: .fit)
              .foregroundStyle(Color.white)
              .frame(size: .smallIcon)
          }
        }
      }
      .padding(.spacing200)
      .background(
        RoundedRectangle(cornerRadius: .radius50)
          .fill(Color.neutral200)
      )
      .frame(minHeight: Constants.minHeight)
      .padding([.bottom, .horizontal], .spacing200)
      .shadow(.light600)
      .task {
        if let duration = item.duration, !Task.isCancelled {
          await sleep(nanoseconds: duration.nanoseconds)
          self.item.wrappedValue = nil
        }
      }
      .id(item)
    }
  } 
} 

private extension TimeInterval {
  var nanoseconds: UInt64 {
    UInt64((self * 1_000_000_000).rounded())
  }
}

private extension AccessibilityIdentifier {
  static let snackbarTitle: Self = .init("snackbarTitle")
}

private enum Constants {
  static let minHeight = 48.0
}
