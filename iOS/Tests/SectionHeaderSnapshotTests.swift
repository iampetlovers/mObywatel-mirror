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
struct SectionHeaderSnapshotTests {
  @MainActor @Test
  func testSectionHeader() {
    assertSnapshots(matching: SectionHeaderTestView())
  }
}

private struct SectionHeaderTestView: View {
  var body: some View {
    GroupBox("Section Header") {
      VStack(alignment: .leading, spacing: .spacing200) {
        Label(title: "Przeczytaj i zaakceptuj regulamin oraz politykę prywatności.")

        Label(title: "Ustaw hasło.")

        Label(title: "Jeśli chcesz, włącz logowanie biometryczne. Ustaw PIN i biometrię.")

        Label(title: "Dodaj pierwszy dokument.")
      }
      .labelStyle(.bullet)
      .contentBox()
    }
    .groupBoxStyle(.sectionHeader)
    .frame(maxHeight: .infinity)
    .padding()
    .background(Color.background.ignoresSafeArea())
  } 
} 
