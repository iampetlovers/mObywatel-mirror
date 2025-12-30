/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public extension View {
  func withTrailingButton(@ViewBuilder _ trailingButton: () -> some View) -> some View {
    modifier(
      WithTrailingButtonModifier(trailingButton: trailingButton)
    )
  }
}

private struct WithTrailingButtonModifier<TrailingButton: View>: ViewModifier {
  private let trailingButton: TrailingButton
  @Environment(\.isEnabled) var isEnabled

  init(@ViewBuilder trailingButton: () -> TrailingButton) {
    self.trailingButton = trailingButton()
  }

  func body(content: Content) -> some View {
    HStack(spacing: .spacing100) {
      content 
        .frame(maxWidth: .infinity, alignment: .leading)

      trailingButton 
        .apply(if: !isEnabled) { $0.opacity(Constants.disabledOpacity) }
    }
    .frame(
      maxWidth: .infinity, 
      minHeight: Constants.spacing550
    )
  }
} 

private enum Constants {
  static let spacing550 = CGFloat(44)
  static let disabledOpacity = CGFloat(0.3)
}
