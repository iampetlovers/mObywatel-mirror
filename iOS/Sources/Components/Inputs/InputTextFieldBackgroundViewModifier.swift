/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

extension View {
  func inputTextFieldBackground(
    isFocused: Bool, 
    isValid: Bool? = nil
  ) -> some View {
    modifier(
      InputTextFieldBackgroundViewModifier(
        isFocused: isFocused, 
        isValid: isValid 
      )
    )
  }
}

struct InputTextFieldBackgroundViewModifier: ViewModifier {
  let isFocused: Bool
  let isValid: Bool?
  @Environment(\.isValid) private var _isValid 
  @Environment(\.isEnabled) private var isEnabled 
  @Environment(\.appTheme) private var appTheme 

  init( 
    isFocused: Bool,
    isValid: Bool? = nil 
  ) {
    self.isFocused = isFocused 
    self.isValid = isValid 
  }

  func body(content: Content) -> some View {
    content.background(
      backgroundView(
        isValid: isValid ?? _isValid, 
        isFocused: isFocused, 
        isEnabled: isEnabled 
      )
    )
  }

  @ViewBuilder
  private func backgroundView(isValid: Bool, isFocused: Bool, isEnabled: Bool) -> some View {
    ZStack {
      RoundedRectangle(cornerRadius: appTheme.cornerRadius.border)
        .fill(Color.white)

      Group {
        switch (isValid, isFocused, isEnabled) {
        case (true, true, true):
          RoundedRectangle(cornerRadius: appTheme.cornerRadius.border)
            .stroke(appTheme.colors.primary900, lineWidth: Constants.selectedLineWidth)

        case (false, true, true):
          RoundedRectangle(cornerRadius: appTheme.cornerRadius.border)
            .stroke(Color.red100, lineWidth: Constants.selectedLineWidth)

        case (_, _, false):
          RoundedRectangle(cornerRadius: appTheme.cornerRadius.border)
            .stroke(Color.neutral30, lineWidth: Constants.unselectedLineWidth)

        case (false, _, true):
          RoundedRectangle(cornerRadius: appTheme.cornerRadius.border)
            .stroke(Color.red100, lineWidth: Constants.unselectedLineWidth)

        default:
          RoundedRectangle(cornerRadius: appTheme.cornerRadius.border)
            .stroke(Color.neutral80, lineWidth: Constants.unselectedLineWidth)
        }
      }
    }
  }
} 

private enum Constants {
  static let selectedLineWidth = 2.0
  static let unselectedLineWidth = 1.0
}
