/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct DropdownButtonStyle: ButtonStyle {
  let label: String
  @Environment(\.isValid) private var isValid
  @Environment(\.isEnabled) private var isEnabled
  @Environment(\.appTheme) private var appTheme

  public init(label: String) {
    self.label = label 
  }

  public func makeBody(configuration: Configuration) -> some View {
    VStack(alignment: .leading, spacing: .spacing50) {
      Text(label)
        .font(.footnote)
        .foregroundStyle(isEnabled ? Color.neutral200 : Color.neutral60)

      HStack {
        configuration.label

        Spacer()

        Icons.Outline.Navigation.chevronDown
          .resizable()
          .aspectRatio(contentMode: .fit)
          .frame(size: Constants.iconSize)
          .foregroundStyle(isEnabled ? Color.neutral200 : Color.neutral60)
      }
      .contentShape(.rect)
      .padding(.spacing200)
      .background(
        ZStack {
          RoundedRectangle(cornerRadius: appTheme.cornerRadius.border)
            .fill(Color.white)

          RoundedRectangle(cornerRadius: appTheme.cornerRadius.border)
            .stroke(borderColor, lineWidth: Constants.borderWidth)
        }
      )
    }
  }
} 

private extension DropdownButtonStyle {
  var borderColor: Color {
    guard isValid else { return .red100 }
    return isEnabled ? .neutral80 : .neutral30
  }
}

extension ButtonStyle where Self == DropdownButtonStyle {
  public static func dropdown(_ label: String) -> Self { .init(label: label) }
}

private enum Constants {
  static let borderWidth = 1.0
  static let iconSize = 24.0
}
