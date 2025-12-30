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
struct InputTextFieldSnapshotTests {
  @MainActor @Test
  func testInvalidTextField() {
    let text: Binding<String> = .constant("Lorem ipsum dolor sit amet")
    let validationMessage: String = "Excepteur sint occaecat cupidatat non proident"
    assertSnapshots(
      matching: TestView { _ in
        InputTextField(text: .empty)
          .environment(\.isValid, false)
          .validation(validationMessage)

        InputTextField(
          label: "Ut enim ad minim veniam", 
          placeholder: "Excepteur", 
          text: .empty
        )
        .environment(\.isValid, false)
        .validation(validationMessage)

        InputTextField(text: text)
          .environment(\.isValid, false)
          .validation(validationMessage)








        InputTextField(type: .secure(true), text: text)
          .environment(\.isValid, false)
          .validation(validationMessage)

        InputTextField(type: .secure(false), text: text)
          .environment(\.isValid, false)
          .validation(validationMessage)
      }
    )
  }

  @MainActor @Test
  func testValidTextField() {
    let text: Binding<String> = .constant("Lorem ipsum dolor sit amet")
    assertSnapshots(
      matching: TestView { _ in
        InputTextField(text: .empty)

        InputTextField(
          label: "Ut enim ad minim veniam", 
          placeholder: "Excepteur", 
          text: .empty
        )

        InputTextField(text: text)






        InputTextField(type: .secure(true), text: text)

        InputTextField(type: .secure(false), text: text)
      }
    )
  }

  @MainActor @Test
  func testDisabledTextField() {
    assertSnapshots(
      matching: TestView { _ in
        InputTextField(text: .empty)
          .environment(\.isEnabled, false)

        InputTextField(
          label: "Ut enim ad minim veniam", 
          placeholder: "Excepteur", 
          text: .empty
        )
        .environment(\.isEnabled, false)

        InputTextField(type: .secure(true), text: .empty)
          .environment(\.isEnabled, false)
      }
    )
  }
}

private struct TestView<Content: View>: View {
  @FocusState private var isFocused: Bool
  private let content: (FocusState<Bool>.Binding) -> Content

  init(@ViewBuilder content: @escaping (FocusState<Bool>.Binding) -> Content) {
    self.content = content 
  }

  var body: some View {
    VStack(spacing: .spacing200) {
      content($isFocused)
      Spacer()
    }
    .padding(.spacing200)
    .onAppear { isFocused = true }
    .background(Color.background.ignoresSafeArea())
  }
} 
