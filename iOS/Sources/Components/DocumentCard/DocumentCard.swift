/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct DocumentCard<TrailingItem: View>: View {
  private let title: String
  private let backgroundImage: Image
  private let trailingItem: TrailingItem

  public init( 
    title: String,
    backgroundImage: Image,
    @ViewBuilder trailingItem: () -> TrailingItem
  ) {
    self.trailingItem = trailingItem()
    self.title = title 
    self.backgroundImage = backgroundImage 
  }

  public var body: some View {
    VStack {
      HStack(alignment: .center, spacing: .spacing100) {
        Text(title)
          .font(.headline.weight(.semibold))
          .foregroundStyle(Color.white)
          .multilineTextAlignment(.leading)
          .lineLimit(Constants.lineLimit)
          .frame(maxWidth: .infinity, minHeight: Constants.spacing550, alignment: .leading)

        trailingItem 
          .frame(size: Constants.spacing550)
      }

      Spacer()
    }
    .padding(.top, .spacing100)
    .padding([.bottom, .horizontal], .spacing200)
    .frame(height: Constants.cardHeight)
    .background(backgroundImage.resizable().aspectRatio(contentMode: .fill))
    .clipShape(.rect(cornerRadius: .radius200))
    .shadow(.light600)
  }
} 

private enum Constants {
  static let cardHeight = 226.0
  static let spacing550 = 44.0
  static let lineLimit = 2
}
