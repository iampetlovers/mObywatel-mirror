/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import A11y
import SwiftUI

public struct Accordion<Content>: View where Content: View {
  let title: String
  let isExpanded: Binding<Bool>
  let content: Content

  public init( 
    _ title: String,
    isExpanded: Binding<Bool>, 
    @ViewBuilder content: () -> Content
  ) {
    self.title = title 
    self.content = content()
    self.isExpanded = isExpanded 
  }

  public var body: some View {
    VStack(alignment: .leading, spacing: .spacing200) {
      Button { isExpanded.wrappedValue.toggle() } label: {
        HStack(spacing: .spacing100) {
          Text(title)
            .foregroundStyle(Color.neutral500)
            .font(.headline.weight(.semibold))
            .multilineTextAlignment(.leading)

          Spacer()

          Icons.Outline.Navigation.chevronDown
            .resizable()
            .frame(size: Constants.iconSize)
            .foregroundColor(.neutral200)
            .rotationEffect(
              .degrees(
                isExpanded.wrappedValue ? Constants.rotationDegrees : .zero
              )
            )
            .animation(.easeInOut, value: isExpanded.wrappedValue)
        }
      }
      .accessibilityIdentifier(.toggleExpandedButton)
      .accessibilityLabel(
        Text(
          title 
          + ", "
          + (
            isExpanded.wrappedValue
              ? A11y.commonAccessibilityExpanded
              : A11y.commonAccessibilityNotExpanded
          )
        )
      )

      if isExpanded.wrappedValue {
        VStack(spacing: .spacing200) {
          content 
        }
      }
    }
    .fixedSize(horizontal: false, vertical: true)
  }
} 

private enum Constants {
  static let iconSize = 24.0
  static let rotationDegrees = 180.0
}

private extension AccessibilityIdentifier {
  static let toggleExpandedButton: Self = .init("toggleExpandedButton")
}
