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
struct DropdownButtonSnapshotTests {
  @MainActor @Test
  func testDropdownButtons() {
    assertSnapshots(matching: DropdownButtonTestView())
  }
}

private struct DropdownButtonTestView: View {
  var body: some View {
    VStack(spacing: .spacing200) {
      Button(
        action: {}, 
        label: { Text("Opcja 1") }
      )
      .buttonStyle(.dropdown("Etykieta"))
      .validation(nil)
      .tooltipText("Tekst pomocniczy (helper text).", isHidden: false)

      Button(
        action: {}, 
        label: {
          Text("Placeholder")
            .foregroundStyle(Color.neutral100)
        }
      )
      .buttonStyle(.dropdown("Etykieta"))
      .validation(nil)

      let validationMessage: String? = "Tekst błedu (error text)."
      Button(
        action: {}, 
        label: { Text("Opcja 1") }
      )
      .buttonStyle(.dropdown("Etykieta"))
      .validation(validationMessage)
      .tooltipText("Tekst pomocniczy (helper text).", isHidden: validationMessage != nil)

      Button(
        action: {}, 
        label: {
          Text("Placeholder")
            .foregroundStyle(Color.neutral60)
        }
      )
      .buttonStyle(.dropdown("Etykieta"))
      .validation(nil)
      .disabled(true)
    }
    .contentBox()
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 
