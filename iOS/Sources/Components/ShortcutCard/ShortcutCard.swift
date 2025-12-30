/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct ShortcutCard: View {
  private let foregroundColor: Color
  private let image: Image
  private let title: String

  public init( 
    _ title: String,
    image: Image,
    foregroundColor: Color
  ) {
    self.foregroundColor = foregroundColor 
    self.image = image 
    self.title = title 
  }

  public var body: some View {
    VStack(spacing: .spacing100) {
      ZStack {
        Circle()
          .fill(.white)
          .frame(size: Constants.backgroundSize)
          .shadow(.light200)

        image 
          .resizable()
          .scaledToFit()
          .frame(size: .regularIcon)
          .foregroundStyle(foregroundColor)
      }

      Text(title)
        .font(.caption)
        .foregroundStyle(Color.neutral500)
        .multilineTextAlignment(.center)
    }
    .frame(width: Constants.maxWidth)
  }
} 

private enum Constants {
  static let maxWidth = 80.0
  static let backgroundSize = 48.0
}
