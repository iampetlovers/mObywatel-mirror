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
struct PhoneNumberInputTextFieldSnapshotTests {
  @MainActor @Test
  func testPhoneNumberInputField() {
    assertSnapshots(matching: TestView())
  }
}

private struct TestView: View {
  let countryCode: Binding<String> = .constant("+48") 
  let phoneNumber: Binding<String> = .constant("998877665") 
  let validationMessage: String = "Excepteur sint occaecat cupidatat non proident"
  @AccessibilityFocusState var accessibilityFocused: Field?
  @FocusState var focusedField: Field?

  enum Field {
    case countryCode 
    case phoneNumber 
    case focusedOne 
  }

  var body: some View {
    VStack(spacing: .spacing200) {
      PhoneNumberInputTextField(
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: .empty, 
            validationMessage: nil
          ), 
          localNumber: .init(
            id: Field.phoneNumber, 
            text: .empty, 
            validationMessage: nil
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )

      PhoneNumberInputTextField(
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: .empty, 
            validationMessage: nil
          ), 
          localNumber: .init(
            id: Field.phoneNumber, 
            text: .empty, 
            validationMessage: nil
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )
      .environment(\.isEnabled, false)

      PhoneNumberInputTextField(
        label: "Ut enim ad minim veniam", 
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: .empty, 
            validationMessage: nil, 
            prompt: "Excepteur"
          ), 
          localNumber: .init(
            id: Field.phoneNumber, 
            text: .empty, 
            validationMessage: nil, 
            prompt: "Duis aute irure dolor"
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )

      PhoneNumberInputTextField(
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: countryCode, 
            validationMessage: nil
          ), 
          localNumber: .init(
            id: Field.phoneNumber, 
            text: phoneNumber, 
            validationMessage: nil
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )

      PhoneNumberInputTextField(
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: countryCode, 
            validationMessage: nil
          ), 
          localNumber: .init(
            id: Field.focusedOne, 
            text: phoneNumber, 
            validationMessage: nil
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )

      PhoneNumberInputTextField(
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: .empty, 
            validationMessage: validationMessage 
          ), 
          localNumber: .init(
            id: Field.phoneNumber, 
            text: phoneNumber, 
            validationMessage: nil
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )

      PhoneNumberInputTextField(
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: countryCode, 
            validationMessage: nil
          ), 
          localNumber: .init(
            id: Field.phoneNumber, 
            text: .empty, 
            validationMessage: validationMessage 
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )

      Spacer()
    }
    .padding(.spacing200)
    .onAppear { focusedField = .focusedOne }
    .background(Color.background.ignoresSafeArea())
  }
} 
