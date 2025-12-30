/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct AccessibilityIdentifier {
  fileprivate let rawValue: String

  public init(_ rawValue: String) {
    self.rawValue = rawValue 
  }

  public static func + <T: StringProtocol>(lhs: Self, rhs: T) -> Self {
    .init(lhs.rawValue + seperator + rhs)
  }

  public static func + (lhs: Self, rhs: Self) -> Self {
    lhs + rhs.rawValue
  }

  public static func + <T: RawRepresentable>(lhs: Self, rhs: T) -> Self where T.RawValue: StringProtocol {
    lhs + rhs.rawValue
  }
}

public struct AccessibilityIdentifierGroup {
  fileprivate let rawValue: String

  public init(_ rawValue: String) {
    self.rawValue = rawValue 
  }

  public static func + (lhs: Self, rhs: AccessibilityIdentifier) -> Self {
    .init(lhs.rawValue + seperator + rhs.rawValue)
  }

  public static func + <T: StringProtocol>(lhs: Self, rhs: T) -> Self {
    .init(lhs.rawValue + seperator + rhs)
  }

  public static func + (lhs: Self, rhs: Self) -> Self {
    .init(lhs.rawValue + seperator + rhs.rawValue)
  }
}

private let seperator = "_"

private enum AccessibilityIdentifierGroupKey: EnvironmentKey {
  static let defaultValue: AccessibilityIdentifierGroup? = nil 
}

extension EnvironmentValues {
  fileprivate var accessibilityIdentifierGroup: AccessibilityIdentifierGroup? {
    get { self[AccessibilityIdentifierGroupKey.self] }
    set { self[AccessibilityIdentifierGroupKey.self] = newValue }
  }
}

private struct AccessibilityGroupAttachmentModifier: ViewModifier {
  @Environment(\.accessibilityIdentifierGroup) var accessibilityIdentifierGroup 

  let identifier: AccessibilityIdentifier

  func body(content: Content) -> some View {
    content.accessibilityIdentifier( 
      accessibilityIdentifierGroup 
        .flatMap { $0 + identifier }? 
        .rawValue
        ?? identifier.rawValue
    ) 
  } 
} 

extension View {
  @warn_unqualified_access
  public func accessibilityIdentifier(_ identifier: AccessibilityIdentifier) -> some View {
    self.modifier(AccessibilityGroupAttachmentModifier(identifier: identifier))
  }

  @warn_unqualified_access
  public func accessibilityIdentifierGroup(_ identifier: AccessibilityIdentifierGroup) -> some View {
    self.environment(\.accessibilityIdentifierGroup, identifier)
  }
}

extension UIAccessibilityIdentification {
  public func setAccessibilityIdentifier(_ identifier: AccessibilityIdentifier) {
    self.accessibilityIdentifier = identifier.rawValue
  }
}



extension AccessibilityIdentifier {
  public static let nextButton: Self = .init("nextButton")
  public static let backButton: Self = .init("backButton")
  public static let closeButton: Self = .init("closeButton")
}
