/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

extension ButtonStyleConfiguration.Label {
  var baseStyle: some View {
    self
      .font(.callout.weight(.semibold))
      .padding(.horizontal, .spacing200)
      .padding(.vertical, .spacing100)
      .frame(alignment: .center)
      .frame(maxWidth: .infinity, minHeight: .spacing600)
      .contentShape(.rect(cornerRadius: .radius300))
  }

  var iconBaseStyle: some View {
    self
      .frame(size: .spacing300)
      .padding(.spacing150)
      .frame(alignment: .center)
      .contentShape(.rect(cornerRadius: .radius300))
  }

  var smallBaseStyle: some View {
    self
      .font(.footnote.weight(.semibold))
      .padding(.horizontal, .spacing200)
      .padding(.vertical, .spacing50)
      .frame(alignment: .center)
      .frame(minHeight: .spacing400)
      .contentShape(.rect(cornerRadius: .radius200))
  }

  var iconSmallBaseStyle: some View {
    self
      .frame(size: .spacing300)
      .padding(.spacing50)
      .frame(alignment: .center)
      .contentShape(.rect(cornerRadius: .radius200))
  }
}
