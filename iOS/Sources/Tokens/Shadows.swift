/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/


import SwiftUI

public extension View {
  func shadow(_ shadow: Shadow) -> some View {
    self
      .shadow(
        color: shadow.firstLayer.color, 
        radius: shadow.firstLayer.radius, 
        y: shadow.firstLayer.radius
      )
      .shadow(
        color: shadow.secondLayer.color, 
        radius: shadow.secondLayer.radius, 
        y: shadow.secondLayer.radius
      )
  }
}

public struct Shadow {
  struct Layer {
    let color: Color 
    let radius: CGFloat 
    let y: CGFloat 
  }

  let firstLayer: Layer 
  let secondLayer: Layer 
}

extension Shadow {
  public static let light200: Self = .init(
    firstLayer: .init(color: .neutral500.opacity(0.02), radius: 2, y: 0), 
    secondLayer: .init(color: .neutral500.opacity(0.04), radius: 8, y: 8)
  )

  public static let light400: Self = .init(
    firstLayer: .init(color: .neutral500.opacity(0.02), radius: 4, y: 0), 
    secondLayer: .init(color: .neutral500.opacity(0.04), radius: 12, y: 16)
  )

  public static let light600: Self = .init(
    firstLayer: .init(color: .neutral500.opacity(0.02), radius: 4, y: 0), 
    secondLayer: .init(color: .neutral500.opacity(0.04), radius: 16, y: 24)
  )
}
