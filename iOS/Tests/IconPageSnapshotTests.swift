/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct IconPageSnapshotTests {
  @MainActor @Test
  func testWithRequiredParameters() {
    assertSnapshots(
      matching:
        IconPage(
          title: "Tu pojawią sie Twoje aktualne sprawy urzedowe", 
          description: "Nie widzisz swojej sprawy? Obecnie w aplikacji możesz zobazyć tylko wybrane wnioski złożone przez internet.", 
          icon: { TestEmptyIcon() }
        )
    )
  }

  @MainActor @Test
  func testWithContent() {
    assertSnapshots(
      matching:
        IconPage(
          title: "Aktywuj skrzynkę", 
          description: "Zrobisz to na stronie mObywatel.gov.pl w zakładce Twoje skrzynki", 
          icon: { TestEmptyIcon() }, 
          content: {
            Button("Przejdz do mObywayel.gov.pl", action: {})
              .buttonStyle(.text)
          }
        )
    )
  }

  @MainActor @Test
  func testWithContentAndSubDescription() {
    assertSnapshots(
      matching:
        IconPage(
          title: "Aktywuj skrzynkę", 
          description: "Zrobisz to na stronie mObywatel.gov.pl w zakładce Twoje skrzynki", 
          subDescription: "Poniżej znajdziesz link", 
          icon: { TestEmptyIcon() }, 
          content: {
            Button("Przejdz do mObywayel.gov.pl", action: {})
              .buttonStyle(.text)
          }
        )
    )
  }
}

private struct TestEmptyIcon: View {
  @Environment(\.appTheme) private var appTheme 

  var body: some View {
    Icons.EmptyState.documentBox 
      .resizable() 
      .foregroundStyle(appTheme.colors.primary900) 
      .frame(size: 96)
      .accessibility(hidden: true)
  }
} 
