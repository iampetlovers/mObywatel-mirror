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
struct InlineAlertSnapshotTests {
  @MainActor @Test
  func testShortDescription() {
    let view = InlineAlert(style: .info, description: "Lorem ipsum dolor.")
      .padding()
      .frame(maxWidth: .infinity)

    assertSnapshots(matching: view)
  }

  @MainActor @Test
  func testDefault() {
    let view = InlineAlert(
      style: .info, 
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus."
    )
    .padding()
    .frame(maxWidth: .infinity)

    assertSnapshots(matching: view)
  }

  @MainActor @Test
  func testWithTitle() {
    let view = InlineAlert(
      style: .error, 
      title: "Error alert", 
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus."
    )
    .padding()
    .frame(maxWidth: .infinity)

    assertSnapshots(matching: view)
  }

  @MainActor @Test
  func testWithAction() {
    let view = InlineAlert(
      style: .warning, 
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus.", 
      bottomItem: {
        Button("Text button") {}
          .buttonStyle(.text)
      }
    )
    .padding()
    .frame(maxWidth: .infinity)

    assertSnapshots(matching: view)
  }

  @MainActor @Test
  func testWithTitleAndAction() {
    let view = InlineAlert(
      style: .success, 
      title: "Success alert", 
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus.", 
      bottomItem: {
        Button("Text button") {}
          .buttonStyle(.text)
      }
    )
    .padding()
    .frame(maxWidth: .infinity)

    assertSnapshots(matching: view)
  }

  @MainActor @Test
  func testWithCloseAndAction() {
    let view = InlineAlert(
      style: .info, 
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus.", 
      trailingItem: {
        Button(
          action: {}, 
          label: { Icons.Outline.Navigation.xmark }
        )
      }, 
      bottomItem: {
        Button("Text button") {}
          .buttonStyle(.text)
      }
    )
    .padding()
    .frame(maxWidth: .infinity)

    assertSnapshots(matching: view)
  }

  @MainActor @Test
  func testWithAllElements() {
    let view = InlineAlert(
      style: .info, 
      title: "Info alert", 
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus.", 
      trailingItem: {
        Button(
          action: {}, 
          label: { Icons.Outline.Navigation.xmark }
        )
      }, 
      bottomItem: {
        Button("Text button") {}
          .buttonStyle(.text)
      }
    )
    .padding()
    .frame(maxWidth: .infinity)

    assertSnapshots(matching: view)
  }

  @MainActor @Test
  func testAnnouncement() {
    let view = VStack(spacing: .spacing200) {
      InlineAlert(
        style: .announcement(
          icon: Icons.Brand.Services.fines, 
          color: Color.primary900, 
          backgroundColor: Color.secondary900
        ), 
        title: "Announcement alert", 
        description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus.", 
        trailingItem: {
          Button(
            action: {}, 
            label: { Icons.Outline.Navigation.xmark }
          )
        }, 
        bottomItem: {
          Button("Text button") {}
            .buttonStyle(.text)
        }
      )
      .padding()
      .frame(maxWidth: .infinity)

      InlineAlert(
        style: .announcement(
          icon: Icons.Brand.Services.environmentalViolation, 
          color: Color.leafy100, 
          backgroundColor: Color.leafy30
        ), 
        description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus.", 
        trailingItem: {
          Button(
            action: {}, 
            label: { Icons.Outline.Navigation.xmark }
          )
        }, 
        bottomItem: {
          Button("Link button") {}
            .buttonStyle(.linkStyle)
        }
      )
      .padding()
      .frame(maxWidth: .infinity)

      InlineAlert(
        style: .announcement(
          icon: Icons.Brand.Services.peselRestriction, 
          color: Color.purple100, 
          backgroundColor: Color.purple30
        ), 
        description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus.", 
        trailingItem: {
          Button(
            action: {}, 
            label: { Icons.Outline.Navigation.xmark }
          )
        }
      )
      .padding()
      .frame(maxWidth: .infinity)

      InlineAlert(
        style: .announcement(
          icon: Icons.Brand.Services.news, 
          color: Color.sun80, 
          backgroundColor: Color.sun30
        ), 
        description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus."
      )
      .padding()
      .frame(maxWidth: .infinity)

      Spacer()
    }
    .background(Color.background)

    assertSnapshots(matching: view)
  }
}
