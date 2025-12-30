/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

extension PinInputTextField {
  struct Cell: View {
    struct State: Identifiable {
      let id: UUID
      let strokeColor: Color
      let strokeWidth: CGFloat
      let cornerRadius: CGFloat
      let isBulletPresented: Bool
    }

    var state: State 

    var body: some View {
      RoundedRectangle(cornerRadius: self.state.cornerRadius)
        .stroke(
          self.state.strokeColor, 
          lineWidth: self.state.strokeWidth
        )
        .frame(
          width: Self.width, 
          height: Self.height
        )
        .background(
          Color.white.cornerRadius(self.state.cornerRadius)
        )
        .overlay {
          if self.state.isBulletPresented {
            Circle()
              .fill(Color.neutral500)
              .frame(size: 6)
          }
        }
    }
  }
} 

extension PinInputTextField.Cell.State {
  struct Configuration {
    let isValid: Bool
    let appTheme: AppTheme 
    let isBulletPresented: Bool
  }

  static func focused(with configuration: Configuration) -> Self {
    PinInputTextField.Cell.State(
      id: UUID(), 
      strokeColor: configuration.isValid
        ? configuration.appTheme.colors.primary900
        : .red100, 
      strokeWidth: Constants.selectedLineWidth, 
      cornerRadius: configuration.appTheme.cornerRadius.border, 
      isBulletPresented: configuration.isBulletPresented
    )
  }

  static func unfocused(with configuration: Configuration) -> Self {
    PinInputTextField.Cell.State(
      id: UUID(), 
      strokeColor: configuration.isValid ? .neutral80 : .red100, 
      strokeWidth: Constants.unselectedLineWidth, 
      cornerRadius: configuration.appTheme.cornerRadius.border, 
      isBulletPresented: configuration.isBulletPresented
    )
  }
}

extension PinInputTextField.Cell {
  static let width = 40.0
  static let height = 48.0
}

private enum Constants {
  static let unselectedLineWidth = 1.0
  static let selectedLineWidth = 2.0
}
