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
struct StatusBadgeSnapshotTests {
  @MainActor @Test
  func testStatusBadge() {
    assertSnapshots(matching: TestView())
  }
}

private struct TestView: View {
  let title = "Lorem ipsum" 

  var body: some View {
    VStack(alignment: .leading) {
      VStack {
        Label(title: title)
          .labelStyle(.status(.informativeIcon))

        Label(title: title)
          .labelStyle(.status(.positiveIcon))

        Label(title: title)
          .labelStyle(.status(.negativeIcon))

        Label(title: title)
          .labelStyle(.status(.noticeIcon))

        Label(title: title)
          .labelStyle(.status(.minusIcon))
      }
      .contentBox()

      VStack(alignment: .leading) {
        Label(title: title)
          .labelStyle(.status(.informativeDot))

        Label(title: title)
          .labelStyle(.status(.positiveDot))

        Label(title: title)
          .labelStyle(.status(.negativeDot))

        Label(title: title)
          .labelStyle(.status(.warningDot))
      }
      .contentBox()

      VStack(alignment: .leading) {
        Label(title: title)
          .labelStyle(.status(.borderedInformativeIcon))

        Label(title: title)
          .labelStyle(.status(.borderedPositiveIcon))

        Label(title: title)
          .labelStyle(.status(.borderedNegativeIcon))

        Label(title: title)
          .labelStyle(.status(.borderedNoticeIcon))

        Label(title: title)
          .labelStyle(.status(.borderedMinusIcon))
      }
      .contentBox()

      Spacer()
    }
    .padding(.spacing200)
    .background(Color.background.ignoresSafeArea())
  } 
} 
