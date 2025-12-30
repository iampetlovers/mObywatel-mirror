/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct PrimaryButtonStyle: ButtonStyle {
  let type: ButtonType
  fileprivate var isBlack = false
  @Environment(\.isEnabled) private var isEnabled
  @Environment(\.appTheme) private var appTheme

  public func makeBody(configuration: Configuration) -> some View {
    Group {
      switch type {
      case .large, .largeDestructive:
        configuration.label.baseStyle

      case .small, .smallDestructive:
        configuration.label.smallBaseStyle

      case .iconLarge, .iconLargeDestructive:
        configuration.label.iconBaseStyle

      case .iconSmall, .iconSmallDestructive:
        configuration.label.iconSmallBaseStyle
      }
    }
    .foregroundStyle(foregroundColor)
    .background(
      RoundedRectangle(cornerRadius: radius)
        .fill(backgroundColor)
    )
    .rippleEffect(configuration.isPressed)
  } 
} 

extension ButtonStyle where Self == PrimaryButtonStyle {
  public static func primary(_ type: ButtonType) -> Self {
    .init(type: type)
  }
}

public extension PrimaryButtonStyle {
  var black: Self {
    var mutable = self
    mutable.isBlack = true
    return mutable 
  }
}

private extension PrimaryButtonStyle {
  var foregroundColor: Color {
    guard isEnabled 
    else { return Color.neutral60 }

    switch type {
    case .large, .largeDestructive, .iconLarge, .iconLargeDestructive:
      return Color.white

    case .small, .iconSmall:
      return isBlack ? .white : appTheme.colors.primary900

    case .smallDestructive, .iconSmallDestructive:
      return Color.red100
    }
  }

  var backgroundColor: Color {
    guard isEnabled 
    else { return Color.neutral30 }

    switch type {
    case .large, .iconLarge:
      return isBlack ? .neutral500 : appTheme.colors.primary900

    case .largeDestructive, .iconLargeDestructive:
      return Color.red100

    case .small, .iconSmall:
      return isBlack ? .neutral500 : appTheme.colors.secondary900

    case .smallDestructive, .iconSmallDestructive:
      return Color.red20
    }
  }

  var radius: CGFloat {
    switch type {
    case .iconLarge, .iconLargeDestructive:
      return .radius300

    case .iconSmall, .iconSmallDestructive:
      return .radius200

    case .large, .largeDestructive, .small, .smallDestructive:
      return appTheme.cornerRadius.button
    }
  }
}
