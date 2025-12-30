/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct PinInputTextField: View {
  private let numberOfCells: Int
  @Environment(\.appTheme) var appTheme
  @Environment(\.isValid) private var isValid
  @Binding private var value: String
  @FocusState private var isFocused: Bool

  public init( 
    value: Binding<String>, 
    numberOfCells: Int = 4
  ) {
    self._value = value 
    self.numberOfCells = numberOfCells 
  }

  public var body: some View {
    SecureField(
      "", 
      text: Binding(
        get: { self.value }, 
        set: { self.value = String($0.prefix(self.numberOfCells)) }
      ).removeDuplicates()
    )
    .focused(self.$isFocused)
    .textFieldStyle(
      PinInputTextFieldStyle(
        cells: (0..<self.numberOfCells).map {
          self.stateForCell(at: $0)
        }, 
        isFocused: self.$isFocused 
      )
    )
  }

  private func stateForCell(at index: Int) -> Cell.State {
    let configuration = Cell.State.Configuration(
      isValid: self.isValid, 
      appTheme: self.appTheme, 
      isBulletPresented: index < self.value.count
    )
    return index == self.value.count && self.isFocused
      ? .focused(with: configuration)
      : .unfocused(with: configuration)
  }
} 
