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
struct TextAreaSnapshotTests {
  @MainActor @Test
  func testTextAreas() {
    assertSnapshots(matching: TextAreaTestView())
  }

  @MainActor @Test
  func testTextAreasWithCounter() {
    assertSnapshots(matching: TextAreaWithCounterTestView())
  }
}

private struct TextAreaTestView: View {
  var validationMessage: String? = "Przekroczono liczbę znaków." 
  var body: some View {
    VStack(alignment: .leading, spacing: .spacing400) {
      TextArea(
        "Some placeholder", 
        text: .constant(""), 
        label: "Label", 
        mode: .flexible()
      )
      .tooltipText("Helper")

      TextArea(
        "", 
        text: .constant("Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Cu cum nibh brute quaestio, cu leg. Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Lorem ipsum dolor sit amet, ne est dolorum lucilius."), 
        label: "Label"
      )
      .tooltipText("Helper")

      TextArea(
        "", 
        text: .constant("Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Cu cum nibh brute quaestio, cu leg. Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Lorem ipsum dolor sit amet, ne est dolorum lucilius."), 
        label: "Label"
      )
      .apply(if: validationMessage == nil) {
        $0.tooltipText("Helper")
      }
      .validation(validationMessage)

      TextArea(
        "", 
        text: .constant("Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Cu cum nibh brute quaestio, cu leg. Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Lorem ipsum dolor sit amet, ne est dolorum lucilius."), 
        label: "Label"
      )
      .tooltipText("Helper")
      .disabled(true)
    }
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

private struct TextAreaWithCounterTestView: View {
  var validationMessage: String? = "Przekroczono liczbę znaków." 
  var body: some View {
    VStack(alignment: .leading, spacing: .spacing400) {
      TextArea(
        "Some placeholder", 
        text: .constant(""), 
        label: "Label", 
        maxTextLength: 150
      )
      .tooltipText("Helper")

      TextArea(
        "", 
        text: .constant("Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Cu cum nibh brute quaestio, cu leg"), 
        label: "Label", 
        maxTextLength: 150
      )
      .tooltipText("Helper")

      TextArea(
        "", 
        text: .constant("Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Cu cum nibh brute quaestio, cu leg. Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Lorem ipsum dolor sit amet, ne est dolorum lucilius."), 
        label: "Label", 
        maxTextLength: 150
      )
      .apply(if: validationMessage == nil) {
        $0.tooltipText("Helper")
      }
      .validation(validationMessage)

      TextArea(
        "", 
        text: .constant("Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Cu cum nibh brute quaestio, cu leg. Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Lorem ipsum dolor sit amet, ne est dolorum lucilius."), 
        label: "Label", 
        maxTextLength: 150
      )
      .tooltipText("Helper")
      .disabled(true)
    }
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 
