/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct AccordionSnapshotTests {
  @MainActor @Test
  func testAccordionSingleLineView() {
    assertSnapshots(matching: AccordionSingleLineView())
  }

  @MainActor @Test
  func testAccordionMultiLineView() {
    assertSnapshots(matching: AccordionMultiLineView())
  }
}

private struct AccordionSingleLineView: View {
  var body: some View {
    VStack(spacing: .spacing100) {
      Accordion("Uczniowie/studenci", isExpanded: .constant(true)) {
        VStack(alignment: .leading, spacing: .spacing50) {
          Text("Uczeń szkoły podstawowej:")
            .font(.headline)

          Group {
            Text("Zniżka 50% na bilety komunikacji miejskiej.")
            Text("Darmowy przejazd w godzinach szczytu od poniedziałku do piątku.")
          }
          .font(.subheadline)
          .frame(maxWidth: .infinity, alignment: .leading)
        }
      }
      .contentBox()

      Accordion("Seniorzy", isExpanded: .constant(false)) { }
        .contentBox()

      Spacer()

    }
    .padding()
    .background(Color.background.ignoresSafeArea())
  } 
} 

private struct AccordionMultiLineView: View {
  var body: some View {
    VStack(spacing: .spacing200) {
      VStack(spacing: .zero) {
        Accordion("Uczniowie/studenci", isExpanded: .constant(true)) {
          VStack(alignment: .leading, spacing: .spacing50) {
            Text("Uczeń szkoły podstawowej:")
              .font(.headline)

            Group {
              Text("Zniżka 50% na bilety komunikacji miejskiej.")
              Text("Darmowy przejazd w godzinach szczytu od poniedziałku do piątku.")
            }
            .font(.subheadline)
            .frame(maxWidth: .infinity, alignment: .leading)
          }

          VStack(alignment: .leading, spacing: .spacing50) {
            Text("Student uczelni wyższej:")
              .font(.headline)

            Group {
              Text("Zniżka 30% na bilety komunikacji miejskiej.")
              Text("Możliwość skorzystania z karty miejskiej umożliwiającej dodatkowe ulgi.")
            }
            .font(.subheadline)
            .frame(maxWidth: .infinity, alignment: .leading)
          }
        }

        Divider()
          .padding(.vertical, .spacing200)

        Accordion("Seniorzy", isExpanded: .constant(false)) { }
      }
      .contentBox()

      Spacer()
    }
    .padding()
    .background(Color.background.ignoresSafeArea())
  } 
} 
