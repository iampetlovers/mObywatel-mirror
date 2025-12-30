/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct RadioButton<Label: View, Content: View>: View {
  private let label: Label
  private let content: Content
  @Binding private var isOn: Bool
  @Environment(\.isValid) private var isValid

  public init( 
    @ViewBuilder label: () -> Label,
    @ViewBuilder content: () -> Content = EmptyView.init,
    isOn: Binding<Bool>
  ) {
    self.label = label()
    self.content = content()
    _isOn = isOn 
  }

  public var body: some View {
    VStack(alignment: .leading, spacing: .spacing100) {
      Toggle(isOn: $isOn) { label }
        .toggleStyle(.radio)

      if isOn {
        content 
          .padding(.leading, .spacing500)
          .animation(.easeInOut, value: isOn)
      }
    }
  }
} 

extension RadioButton where Label == Text {
  public init(
    label: String, 
    @ViewBuilder content: () -> Content = EmptyView.init, 
    isOn: Binding<Bool>
  ) {
    self.label = Text(label)
    self.content = content()
    _isOn = isOn 
  }
}
