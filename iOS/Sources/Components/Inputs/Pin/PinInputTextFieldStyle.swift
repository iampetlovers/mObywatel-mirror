/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

typealias Cell = PinInputTextField.Cell

struct PinInputTextFieldStyle: TextFieldStyle {
  private let cells: [Cell.State]
  private let isFocused: FocusState<Bool>.Binding

  init( 
    cells: [Cell.State], 
    isFocused: FocusState<Bool>.Binding
  ) {
    self.cells = cells 
    self.isFocused = isFocused 
  }

  
  public func _body(configuration: TextField<Self._Label>) -> some View {
    ZStack {
      configuration 
        .keyboardType(.numberPad)
        .frame(
          width: Constants.allCellsWidthAndSpacing(self.cells.count), 
          height: Cell.height
        )
        .invisible

      HStack(spacing: Constants.cellSpacing) {
        ForEach(self.cells) {
          Cell(state: $0)
        }
      }
      .onLongPressGesture {}
    }
    .onTapGesture { self.isFocused.wrappedValue = true }
  }
} 

private enum Constants {
  static let cellSpacing = CGFloat.spacing150

  static func allCellsWidthAndSpacing(_ numberOfCells: Int) -> CGFloat {
    Constants.allCellWidth(numberOfCells) + Constants.allCellsSpacing(numberOfCells)
  }

  static func allCellWidth(_ numberOfCells: Int) -> CGFloat {
    Cell.width * CGFloat(numberOfCells)
  }

  static func allCellsSpacing(_ numberOfCells: Int) -> CGFloat {
    CGFloat(numberOfCells - 1) * cellSpacing 
  }
}
