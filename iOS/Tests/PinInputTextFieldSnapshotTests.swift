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
struct PinInputTextFieldSnapshotTests {
  @MainActor @Test
  func testPinInputField() {
    assertSnapshots(matching: TestView())
  }
}

private struct TestView: View {
  let text: Binding<String> = .constant("123456") 
  let validationMessage: String = "Excepteur sint occaecat cupidatat non proident"

  var body: some View {
    VStack(alignment: .center, spacing: .spacing200) {
      PinInputTextField(value: .empty)

      PinInputTextField(value: text)

      PinInputTextField(value: text)
        .environment(\.isValid, false)
        .validation(validationMessage, alignment: .center)

      PinInputTextField(value: .empty, numberOfCells: 6)

      PinInputTextField(value: text, numberOfCells: 6)

      PinInputTextField(value: text, numberOfCells: 6)
        .environment(\.isValid, false)
        .validation(validationMessage, alignment: .center)

      Spacer()
    }
    .padding(.spacing200)
    .background(Color.background.ignoresSafeArea())
  } 
} 
