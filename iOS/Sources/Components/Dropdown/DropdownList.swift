/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct DropdownList<Item: Selectable, RowContent: View>: View {
  private let items: [Item]
  private let rowContent: (Item) -> RowContent
  @Binding var selectedItem: Item?
  @Environment(\.dismiss) private var dismiss 
  @Environment(\.appTheme) private var appTheme 

  public init( 
    _ items: [Item], 
    selectedItem: Binding<Item?>, 
    @ViewBuilder rowContent: @escaping (Item) -> RowContent
  ) {
    self.items = items 
    _selectedItem = selectedItem 
    self.rowContent = rowContent 
  }

  public var body: some View {
    if #available(iOS 17.0, *) {
      list 
        .onChange(of: selectedItem) { _, _ in dismiss() }
    } else {
      list 
        .onChange(of: selectedItem) { _ in dismiss() }
    }
  }
} 

public extension DropdownList where RowContent == Text {
  init(
    _ items: [Item], 
    selectedItem: Binding<Item?>
  ) {
    self.init(
      items, 
      selectedItem: selectedItem, 
      rowContent: {
        Text($0.text)
          .font(.headline.weight(.semibold))
      }
    )
  }
}

private extension DropdownList {
  var list: some View {
    List(items, id: \.self, selection: $selectedItem) { item in
      HStack {
        self.rowContent(item)

        Spacer()

        if item == selectedItem {
          Image(systemName: "checkmark")
            .foregroundStyle(appTheme.colors.primary900)
            .font(.headline.weight(.semibold))
        }
      }
      .listRowBackground(Color.white)
      .padding(.vertical, .spacing200)
    }
    .environment(\.editMode, .constant(.active))
  }
}
