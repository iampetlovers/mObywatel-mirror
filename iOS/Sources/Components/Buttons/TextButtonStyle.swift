/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct TextButtonStyle: ButtonStyle {
  @Environment(\.isEnabled) private var isEnabled 
  @Environment(\.appTheme) private var appTheme 

  public func makeBody(configuration: Configuration) -> some View {
    configuration.label 
      .font(.footnote.weight(.semibold)) 
      .frame(alignment: .center)
      .frame(minHeight: Constants.minHeight)
      .contentShape(.rect) 
      .foregroundStyle(isEnabled ? appTheme.colors.primary900 : Color.neutral60)
      .rippleEffect(configuration.isPressed) 
  }
} 

public struct DestructiveTextButtonStyle: ButtonStyle {
  @Environment(\.isEnabled) private var isEnabled 

  public func makeBody(configuration: Configuration) -> some View {
    configuration.label 
      .font(.footnote.weight(.semibold)) 
      .frame(alignment: .center)
      .frame(minHeight: Constants.minHeight)
      .contentShape(.rect) 
      .foregroundStyle(isEnabled ? Color.red100 : Color.neutral60)
      .rippleEffect(configuration.isPressed) 
  }
} 

extension ButtonStyle where Self == TextButtonStyle {
  public static var text: Self { .init() }
}

extension ButtonStyle where Self == DestructiveTextButtonStyle {
  public static var destructiveText: Self { .init() }
}

private enum Constants {
  static let minHeight = 18.0
}
