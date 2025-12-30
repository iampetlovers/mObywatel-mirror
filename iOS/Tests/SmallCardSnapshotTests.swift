/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct SmallCardSnapshotTests {
  @MainActor @Test
  func testSmallCards() {
    assertSnapshots(matching: SmallCardTestView())
  }
}

private struct SmallCardTestView: View {
  var body: some View {
    HStack(spacing: .spacing250) {
      SmallCard.yourAffairs

      SmallCard.fines

      SmallCard.airQuality
    }
    .frame(maxWidth: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

private extension SmallCard {
  static var yourAffairs: Self {
    .init(
      foregroundColor: .sun80, 
      image: Icons.Brand.Services.yourAffairs, 
      title: "Twoje sprawy"
    )
  }

  static var fines: Self {
    .init(
      foregroundColor: .cornflower100, 
      image: Icons.Brand.Services.fines, 
      title: "Mandaty"
    )
  }

  static var airQuality: Self {
    .init(
      foregroundColor: .snow100, 
      image: Icons.Brand.Services.airQuality, 
      title: "Jakość powietrza"
    )
  }
}
