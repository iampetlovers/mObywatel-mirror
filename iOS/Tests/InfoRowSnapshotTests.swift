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
struct InfoRowSnapshotTests {
  @MainActor @Test
  func testInfoRows() {
    assertSnapshots(matching: InfoRowTestView())
  }

  @MainActor @Test
  func testBullets() {
    assertSnapshots(matching: BulletTestView())
  }
}

private struct BulletTestView: View {
  var body: some View {
    VStack(alignment: .leading, spacing: .spacing200) {
      Label(title: "Przeczytaj i zaakceptuj regulamin oraz politykę prywatności.")

      Label(title: "Ustaw hasło.")

      Label(title: "Jeśli chcesz, włącz logowanie biometryczne. Ustaw PIN i biometrię.")

      Label(title: "Dodaj pierwszy dokument.")
    }
    .labelStyle(.bullet)
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

private struct InfoRowTestView: View {
  var body: some View {
    VStack(alignment: .leading, spacing: .spacing200) {
      Label(
        title: "E-wizyta w ZUS", 
        description: "Umów się na wideorozmowę z pracownikiem ZUS w dogodnym terminie. Załatwisz swoje sprawy z dowolnego miejsca."
      ) {
        Icons.Brand.Services.zusVisit
          .resizable()
          .foregroundStyle(Color.grass80)
      }

      Label(
        title: "Jakość powietrza", 
        description: "Dowiedz się, jakim powietrzem oddychasz. Możesz znajdować i zapisywać punkty pomiarowe z całego kraju. Szybko sprawdzisz aktualną jakość powietrza."
      ) {
        Icons.Brand.Services.airQuality
          .resizable()
          .foregroundStyle(Color.snow100)
      }

      Label(
        title: "Historia pojazdu", 
        description: "Kupujesz używany samochód lub motocykl? Sprawdź najważniejsze informacje o pojeździe. Wystarczy, że wpiszesz numer VIN i numer rejestracyjny."
      ) {
        Icons.Brand.Services.vehicleHistory
          .resizable()
          .foregroundStyle(Color.celadon100)
      }
    }
    .labelStyle(.infoRow)
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 
