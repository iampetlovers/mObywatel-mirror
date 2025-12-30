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
struct DropdownListSnapshotTests {
  @MainActor @Test
  func testDropdownListSelected() {
    assertSnapshots(matching: DropdownList(.testItems, selectedItem: .constant(.selectedItem)))
  }

  @MainActor @Test
  func testDropdownListUnselected() {
    assertSnapshots(matching: DropdownList(.testItems, selectedItem: .constant(nil)))
  }

  @MainActor @Test
  func testDropdownListRowContent() {
    assertSnapshots(
      matching: DropdownList(
        .testItems, 
        selectedItem: .constant(.selectedItem), 
        rowContent: { item in
          GroupBox(item.text) {
            Text(item.reversed)
          }
          .groupBoxStyle(.singleCard.reversed)
        }
      )
    )
  }
}

private struct Item: Selectable {
  var text: String

  var reversed: String {
    String(self.text.reversed()).capitalized 
  }
} 

private extension Item {
  static let selectedItem = Item(text: "Środa")
}

private extension Array where Element == Item {
  static let testItems = [ 
    "Poniedziałek", 
    "Wtorek", 
    "Środa", 
    "Czwartek", 
    "Piątek", 
    "Sobota", 
    "Niedziela"
  ] 
  .map(Item.init(text:))
}
