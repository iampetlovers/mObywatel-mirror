/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct HeaderView<Content: View>: View {
  private let icon: Image
  private let iconColor: Color?
  private let iconBackgroundColor: Color
  private let title: String
  private let description: String?
  private let useDefaultBackground: Bool
  private let content: Content

  public init( 
    icon: Image,
    iconColor: Color? = nil, 
    iconBackgroundColor: Color,
    title: String,
    description: String? = nil, 
    useDefaultBackground: Bool = true, 
    @ViewBuilder content: () -> Content
  ) {
    self.icon = icon 
    self.iconColor = iconColor 
    self.iconBackgroundColor = iconBackgroundColor 
    self.title = title 
    self.description = description 
    self.useDefaultBackground = useDefaultBackground 
    self.content = content()
  }

  public var body: some View {
    VStack(alignment: .leading, spacing: .spacing200) {
      ZStack {
        Circle()
          .fill(iconBackgroundColor)
          .frame(size: Constants.iconBackgroundSize)

        icon 
          .resizable()
          .apply(ifLet: iconColor) { $0.foregroundStyle($1) }
          .aspectRatio(contentMode: .fit)
          .frame(size: Constants.iconSize)
      }
      .accessibilityHidden(true)
      .frame(maxWidth: .infinity, alignment: .leading)

      VStack(alignment: .leading, spacing: .spacing100) {
        Text(title)
          .font(.largeTitle.weight(.bold))
          .foregroundStyle(Color.neutral500)
          .multilineTextAlignment(.leading)
          .fixedSize(horizontal: false, vertical: true)
          .accessibilityIdentifier(.headerViewTitle)
          .frame(maxWidth: .infinity, alignment: .leading)

        if let description {
          Text(description)
            .font(.body)
            .foregroundStyle(Color.neutral200)
            .multilineTextAlignment(.leading)
            .fixedSize(horizontal: false, vertical: true)
            .accessibilityIdentifier(.headerViewSubtitle)
            .frame(maxWidth: .infinity, alignment: .leading)
        }
      }

      content 
        .padding(.top, .spacing100)
    }
    .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
    .apply(if: self.useDefaultBackground) { content in
      content.background(Color.background.ignoresSafeArea())
    }
  }
} 

private extension AccessibilityIdentifier {
  static let headerViewTitle: Self = .init("headerViewTitle")
  static let headerViewSubtitle: Self = .init("headerViewSubtitle")
}

private enum Constants {
  static let iconBackgroundSize = 72.0
  static let iconSize = 40.0
}
