/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

struct TooltipModifier<Tooltip>: ViewModifier where Tooltip: View {
  let isHidden: Bool
  let padding: CGFloat
  let tooltip: () -> Tooltip

  func body(content: Content) -> some View {
    VStack(alignment: .leading, spacing: padding) {
      content 

      if !isHidden {
        tooltip()
      }
    }
  } 
} 

extension View {
  @warn_unqualified_access
  public func tooltip<Tooltip>(
    isHidden: Bool = false, 
    padding: CGFloat = .spacing50, 
    @ViewBuilder _ tooltip: @escaping () -> Tooltip 
  ) -> some View where Tooltip: View {
    modifier(
      TooltipModifier(
        isHidden: isHidden, 
        padding: padding, 
        tooltip: tooltip 
      )
    )
  }
}

extension View {
  @warn_unqualified_access
  public func tooltipText(
    _ text: String, 
    padding: CGFloat = .spacing50, 
    isHidden: Bool = false
  ) -> some View {
    self
      .tooltip(isHidden: isHidden, padding: padding) {
        Text(text)
          .multilineTextAlignment(.leading)
          .foregroundStyle(Color.neutral200)
          .font(.caption)
          .accessibilityIdentifier(.tooltipText)
      }
  }
}

private extension AccessibilityIdentifier {
  static let tooltipText: Self = .init("tooltipText")
}
