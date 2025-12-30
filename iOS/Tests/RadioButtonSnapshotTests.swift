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
struct RadioButtonSnapshotTests {
  @MainActor @Test
  func testRadioButton() {
    assertSnapshots(
      matching: RadioButtonTestView(), 
      as: [ 
        .iPhone13Mini(.scaled(1.6)), 
        .iPhone13ProMax(.scaled(1.5))
      ] 
    )
  }
}

private struct RadioButtonTestView: View {
  var body: some View {
    ScrollView {
      Group {
        VStack(spacing: .spacing200) {
          RadioButton(label: "Opcja 1", isOn: .constant(false))

          Divider()

          RadioButton(label: "Opcja 2", isOn: .constant(false))

          Divider()

          RadioButton(label: "Opcja 3", isOn: .constant(true))
        }
        .toggleStyle(.radio)
        .contentBox()

        VStack(spacing: .spacing200) {
          RadioButton(
            label: {
              VStack(alignment: .leading, spacing: .spacing100) {
                Text("Opcja 1")

                Text("Opis")
                  .foregroundStyle(Color.neutral200)
              }
            }, 
            content: {
              VStack(spacing: .spacing200) {
                Button(
                  action: {}, 
                  label: { Text("Opcja 1") }
                )
                .buttonStyle(.dropdown("Etykieta"))
                .validation(nil)
                .tooltipText("Tekst pomocniczy (helper text).", isHidden: false)
              }
            }, 
            isOn: .constant(true)
          )

          Divider()

          RadioButton(
            label: {
              VStack(alignment: .leading, spacing: .spacing100) {
                Text("Opcja 2")

                Text("Opis")
                  .foregroundStyle(Color.neutral200)
              }
            }, 
            isOn: .constant(false)
          )
        }
        .contentBox()

        VStack(spacing: .spacing200) {
          RadioButton(label: "Opcja 1", isOn: .constant(false))
            .disabled(true)

          Divider()

          RadioButton(label: "Opcja 2", isOn: .constant(true))
            .disabled(true)
        }
        .toggleStyle(.radio)
        .contentBox()

        VStack(spacing: .spacing200) {
          RadioButton(label: "Opcja 1", isOn: .constant(false))

          Divider()

          RadioButton(label: "Opcja 2", isOn: .constant(true))
        }
        .toggleStyle(.radio)
        .validation("Tekst błędu", padding: .spacing200)
        .contentBox()
      }
      .padding(.spacing200)
    }
    .background(Color.background.ignoresSafeArea())
  } 
} 
