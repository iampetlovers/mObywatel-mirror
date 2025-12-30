/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

private enum IsValidKey: EnvironmentKey {
  static var defaultValue = true 
}

extension EnvironmentValues {
  public var isValid: Bool {
    get { self[IsValidKey.self] }
    set { self[IsValidKey.self] = newValue }
  }
}

private struct ValidationModifier: ViewModifier {
  let validationMessage: String?
  let alignment: Alignment
  let padding: CGFloat
  @Environment(\.accessibilityVoiceOverEnabled) private var isVoiceOverEnabled: Bool

  func body(content: Content) -> some View {
    VStack(spacing: padding) {
      content 
        .environment(\.isValid, validationMessage == nil)

      if let validationMessage {
        Label(
          title: { Text(validationMessage) }, 
          icon: {
            Icons.Dedicated.errorMarkSmall
              .resizable()
              .aspectRatio(contentMode: .fit)
              .frame(size: .smallIcon)
          }
        )
        .labelStyle(.error)
        .frame(maxWidth: .infinity, alignment: alignment)
        .accessibilityIdentifier(.errorLabel)
        .fixedSize(horizontal: false, vertical: true)
      }
    }
    .apply(if: isVoiceOverEnabled) {
      $0
        .accessibilityElement(children: .contain)
        .accessibilityLabel(validationMessage ?? "")
    }
  } 
} 

extension View {
  @warn_unqualified_access
  public func validation(
    _ validationMessage: String?, 
    alignment: Alignment = .leading, 
    padding: CGFloat = .spacing50
  ) -> some View {
    self.modifier(
      ValidationModifier(
        validationMessage: validationMessage, 
        alignment: alignment, 
        padding: padding 
      )
    )
  }
}

extension LabelStyle where Self == ErrorLabelStyle {
  static var error: Self { .init() }
}

private struct ErrorLabelStyle: LabelStyle {
  func makeBody(configuration: Configuration) -> some View {
    HStack(spacing: .spacing50) {
      configuration.icon
        .frame(size: .smallIcon)

      configuration.title
        .font(.caption)
        .multilineTextAlignment(.leading)
    }
    .foregroundStyle(Color.red100)
  } 
} 

private extension AccessibilityIdentifier {
  static let errorLabel: Self = .init("errorLabel")
}
