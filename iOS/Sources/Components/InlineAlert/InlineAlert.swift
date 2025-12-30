/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import A11y
import SwiftUI

public struct InlineAlert<TrailingItem, BottomItem>: View
where TrailingItem: View, BottomItem: View {
  public enum Style {
    case success
    case error
    case warning
    case info
    case announcement(icon: Image, color: Color, backgroundColor: Color)
  }

  private let style: Style 
  private var title: String?
  private let description: String
  private let trailingItem: TrailingItem 
  private let bottomItem: BottomItem 
  @Environment(\.accessibilityVoiceOverEnabled) private var isVoiceOverEnabled 

  public init(
    style: Style, 
    title: String? = nil, 
    description: String, 
    @ViewBuilder trailingItem: () -> TrailingItem = EmptyView.init, 
    @ViewBuilder bottomItem: () -> BottomItem = EmptyView.init
  ) {
    self.style = style 
    self.title = title 
    self.description = description 
    self.trailingItem = trailingItem()
    self.bottomItem = bottomItem()
  }

  public var body: some View {
    HStack(alignment: .top, spacing: .spacing100) {
      style.icon
        .padding(.trailing, .spacing100)
        .apply(if: isVoiceOverEnabled) { icon in
          if let accessibilityLabel = style.accessibilityLabel {
            icon 
              .accessibilityLabel(accessibilityLabel)
              .accessibilityRemoveTraits(.isImage)
          } else {
            icon 
              .accessibilityHidden(true)
          }
        }

      VStack(alignment: .leading, spacing: .spacing50) {
        if let title {
          Text(title)
            .font(.headline.weight(.semibold))
            .foregroundStyle(Color.neutral500)
            .fixedSize(horizontal: false, vertical: true)
            .frame(maxWidth: .infinity, alignment: .leading)
        }

        VStack(alignment: .leading, spacing: .spacing100) {
          Text(description)
            .font(.footnote)
            .foregroundStyle(Color.neutral500)
            .fixedSize(horizontal: false, vertical: true)
            .frame(maxWidth: .infinity, alignment: .leading)

          bottomItem 
        }
      }
      .frame(minHeight: .spacing300)

      trailingItem 
        .frame(size: .spacing300)
        .foregroundStyle(Color.neutral200)
    }
    .contentBox(color: style.backgroundColor, shadow: nil)
  }
}

private extension InlineAlert.Style {
  var backgroundColor: Color {
    switch self {
    case .error:
      return .red20

    case .info:
      return .blue20

    case .warning:
      return .orange20

    case .success:
      return .green20

    case .announcement:
      return .white
    }
  }

  @ViewBuilder
  var icon: some View {
    switch self {
    case .error:
      Icons.Support.error
        .resizable()
        .foregroundStyle(Color.red100)
        .frame(size: .spacing300)

    case .info:
      Icons.Support.info
        .resizable()
        .foregroundStyle(Color.blue100)
        .frame(size: .spacing300)

    case .warning:
      Icons.Support.warning
        .resizable()
        .foregroundStyle(Color.orange100)
        .frame(size: .spacing300)

    case .success:
      Icons.Support.success
        .resizable()
        .foregroundStyle(Color.green100)
        .frame(size: .spacing300)

    case let .announcement(icon, color, backgroundColor):
      ZStack {
        Circle()
          .foregroundStyle(backgroundColor)
          .frame(size: .spacing600)

        icon 
          .resizable()
          .foregroundStyle(color)
          .frame(size: .spacing300)
      }
    }
  }

  var accessibilityLabel: String? {
    switch self {
    case .error:
      return A11y.commonAccessibilityCriticalInformation

    case .info:
      return A11y.commonAccessibilityInformation

    case .warning:
      return A11y.commonAccessibilityWarningInformation

    case .success:
      return A11y.commonAccessibilitySuccessInformation

    case .announcement:
      return nil
    }
  }
}
