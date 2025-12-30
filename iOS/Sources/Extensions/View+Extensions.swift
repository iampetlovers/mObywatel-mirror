/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

extension View {
  @warn_unqualified_access
  public func frame(
    size: CGFloat, 
    alignment: Alignment = .center
  ) -> some View {
    frame(
      width: size, 
      height: size, 
      alignment: alignment 
    )
  }

  @warn_unqualified_access
  @ViewBuilder
  public func apply<Content: View>(
    if condition: Bool, 
    transformation: (Self) -> Content 
  ) -> some View {
    if condition {
      transformation(self)
    } else {
      self
    }
  }

  @warn_unqualified_access
  @ViewBuilder
  public func apply<Value, Content: View>(
    ifLet value: Value?, 
    transformation: (Self, Value) -> Content 
  ) -> some View {
    if let value {
      transformation(self, value)
    } else {
      self
    }
  }

  @warn_unqualified_access
  @ViewBuilder
  public func accessibilityLabel(
    _ label: String, 
    validationMessage: String?
  ) -> some View {
    self.apply(ifLet: validationMessage) {
      $0.accessibilityLabel($1 + ", " + label)
    }
  }
}
