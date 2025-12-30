/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct LeadingLabelStyle: LabelStyle {
  public enum LeadingStyle {
    case icon 
    case image 
    case placeholder 
    case clickable 
    case destructive 
    case custom 
  }

  private var style: LeadingStyle 
  @Environment(\.isEnabled) private var isEnabled 
  @Environment(\.appTheme) private var appTheme 

  public init(style: LeadingStyle) {
    self.style = style 
  }

  public func makeBody(configuration: Configuration) -> some View {
    HStack(alignment: .center, spacing: .spacing200) {
      configuration.icon
        .apply(if: iconSize != nil) { $0.frame(size: iconSize ?? .regularIcon) }
        .apply(if: iconForegroundColor != nil) { $0.foregroundStyle(iconForegroundColor ?? .neutral200) }
        .apply(if: !isEnabled) { $0.opacity(Constants.disabledOpacity) }
        .apply(if: style == .placeholder) {
          $0
            .padding(Constants.spacing125)
            .background(Color.background)
        }
        .apply(if: style == .placeholder || style == .image) {
          $0.clipShape(.rect(cornerRadius: .radius150))
        }

      configuration.title
        .foregroundStyle(foregroundColor(isEnabled))
        .font(.headline.weight(.semibold))
        .frame(minHeight: .spacing300)
        .accessibilityElement(children: .combine)
    }
    .multilineTextAlignment(.leading)
    .frame(
      maxWidth: .infinity, 
      minHeight: Constants.spacing550, 
      alignment: .leading
    )
  }
} 

public extension LabelStyle where Self == LeadingLabelStyle {
  static func leading(_ style: LeadingLabelStyle.LeadingStyle) -> Self {
    .init(style: style)
  }
}

private extension LeadingLabelStyle {
  var iconSize: CGFloat? {
    switch self.style {
    case
        .icon, 
        .placeholder, 
        .destructive, 
        .clickable:
      return .regularIcon

    case .image:
      return Constants.spacing550

    case .custom:
      return nil
    }
  }

  var iconForegroundColor: Color? {
    switch self.style {
    case .clickable:
      return appTheme.colors.primary900

    case .destructive:
      return Color.red100

    case .custom:
      return nil

    case
        .icon, 
        .placeholder, 
        .image:
      return Color.neutral200
    }
  }

  func foregroundColor(_ isEnabled: Bool) -> Color {
    guard isEnabled 
    else { return Color.neutral60 }

    switch self.style {
    case .clickable:
      return appTheme.colors.primary900

    case .destructive:
      return Color.red100

    case
        .icon, 
        .placeholder, 
        .image, 
        .custom:
      return Color.neutral500
    }
  }
}

private enum Constants {
  static let spacing550 = 44.0
  static let spacing125 = 10.0
  static let disabledOpacity = 0.3
}
