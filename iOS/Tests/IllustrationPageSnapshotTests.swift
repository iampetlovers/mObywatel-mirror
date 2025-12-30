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
struct IllustrationPageSnapshotTests {
  @MainActor @Test
  func testWithRequiredParameters() {
    let view = GeometryReader { geometry in
      IllustrationPage(
        title: "Załatwiaj wygodnie sprawy urzędowe", 
        illustration: {
          TestIllustration()
            .frame(height: geometry.size.height * 0.3)
        }
      )
    }

    assertSnapshots(matching: view)
  }

  @MainActor @Test
  func testWithDescription() {
    let view = GeometryReader { geometry in
      IllustrationPage(
        title: "Załatwiaj wygodnie sprawy urzędowe", 
        description: "Wystarczy, że zeskanujesz kod QR ze strony e‑Urzędu Skarbowego lub mObywatela w przeglądarce. Nie potrzebujesz loginu i hasła.", 
        illustration: {
          TestIllustration()
            .frame(height: geometry.size.height * 0.3)
        }
      )
    }

    assertSnapshots(matching: view)
  }

  @MainActor @Test
  func testWithContentAndDescription() {
    let view = GeometryReader { geometry in
      IllustrationPage(
        title: "Załatwiaj wygodnie sprawy urzędowe", 
        description: "Wystarczy, że zeskanujesz kod QR ze strony e‑Urzędu Skarbowego lub mObywatela w przeglądarce. Nie potrzebujesz loginu i hasła.", 
        illustration: {
          TestIllustration()
            .frame(height: geometry.size.height * 0.3)
        }, 
        content: {
          Button("Przejdz do najczęściej zadawanych pytań", action: {})
            .buttonStyle(.text)
        }
      )
    }

    assertSnapshots(matching: view)
  }
}

private struct TestIllustration: View {
  var body: some View {
    Image("illustration_page", bundle: .module)
      .resizable() 
      .scaledToFit() 
  }
} 
