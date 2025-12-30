/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct IconPage<Icon, Content>: View
where Icon: View, Content: View {
  private let icon: Icon 
  private let title: String
  private let description: String?
  private let subDescription: String?
  private let content: Content 

  public init(
    title: String, 
    description: String? = nil, 
    subDescription: String? = nil, 
    @ViewBuilder icon: @escaping () -> Icon, 
    @ViewBuilder content: @escaping () -> Content = EmptyView.init
  ) {
    self.title = title 
    self.description = description 
    self.subDescription = subDescription 
    self.icon = icon()
    self.content = content()
  }

  public var body: some View {
    VStack(spacing: .spacing200) {
      Spacer()

      icon 
        .accessibilityHidden(true)

      Group {
        Text(title)
          .font(.title2.bold())
          .foregroundStyle(Color.neutral500)
          .fixedSize(horizontal: false, vertical: true)
          .frame(maxWidth: .infinity)

        if let description {
          Text(description)
            .fixedSize(horizontal: false, vertical: true)
        }
        if let subDescription {
          Text(subDescription)
            .fixedSize(horizontal: false, vertical: true)
        }
      }
      .foregroundStyle(Color.neutral200)
      .multilineTextAlignment(.center)

      content 

      Spacer()
    }
    .padding(.horizontal, .spacing200)
  }
}
