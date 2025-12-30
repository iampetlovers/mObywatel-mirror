/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct SmallCard: View {
  private let foregroundColor: Color
  private let image: Image
  private let title: String

  public init( 
    foregroundColor: Color,
    image: Image,
    title: String
  ) {
    self.foregroundColor = foregroundColor 
    self.image = image 
    self.title = title 
  }

  public var body: some View {
    VStack(spacing: .spacing100) {
      ZStack {
        iconBackground 
        icon 
      }

      text 
    }
  }
} 

private extension SmallCard {
  var iconBackground: some View {
    Constants.smallCardBackground
      .resizable()
      .frame(size: Constants.iconBackgroundSize)
      .shadow(.light200)
  }

  var icon: some View {
    image 
      .resizable()
      .renderingMode(.template)
      .foregroundStyle(foregroundColor)
      .aspectRatio(contentMode: .fit)
      .frame(size: Constants.iconSize)
  }

  var text: some View {
    Text(title)
      .font(.caption)
      .foregroundStyle(Color.neutral200)
      .lineLimit(Constants.lineLimit)
      .multilineTextAlignment(.center)
      .frame(
        maxWidth: Constants.textMaxWidth, 
        maxHeight: .infinity, 
        alignment: .top
      )
  }
}

private enum Constants {
  static let lineLimit = 2
  static let textMaxWidth = 92.0
  static let iconBackgroundSize = 80.0
  static let iconSize = 32.0
  static let smallCardBackground = Image("smallCardBackground", bundle: .module)
}
