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
struct SingleCardSnapshotTests {
  @MainActor @Test
  func testSingleCardBodySection() {
    assertSnapshots(matching: SingleCardBodySectionTestView())
  }

  @MainActor @Test
  func testSingleCardLeadingSection() {
    assertSnapshots(
      matching: SingleCardLeadingSectionTestView(), 
      as: [ 
        .iPhone13Mini(.scaled(1.2)), 
        .iPhone13ProMax(.default)
      ] 
    )
  }

  @MainActor @Test
  func testSingleCardLeadingToggleSection() {
    assertSnapshots(matching: SingleCardLeadingToggleSectionTestView())
  }

  @MainActor @Test
  func testSingleCardTopAndBottomSection() {
    assertSnapshots(matching: NavigationView { SingleCardTopAndBottomSectionTestView() })
  }

  @MainActor @Test
  func testSingleCardTrailingSection() {
    assertSnapshots(matching: NavigationView { SingleCardTrailingSectionTestView() })
  }

  @MainActor @Test
  func testSingleCardViewAsNavigationLink() {
    assertSnapshots(matching: SingleCardNavigationLinkView())
  }
}



private struct SingleCardBodySectionTestView: View {
  var body: some View {
    List {
      Section {
        VStack(spacing: .spacing200) {
          GroupBox("Label") {
            Text("Title")
          }
          .groupBoxStyle(.singleCard)

          Divider()

          GroupBox("Title") {
            Text("Description")
          }
          .groupBoxStyle(.singleCard.reversed)

          Divider()

          GroupBox("Label") {
            GroupBox("Title") {
              Text("Description")
            }
            .groupBoxStyle(.singleCard.reversed)
          }
          .groupBoxStyle(.singleCard)

          Divider()

          GroupBox("Label") {
            Label(title: "Label")
              .labelStyle(.status(.informativeDot))
          }
          .groupBoxStyle(.singleCard)

          Divider()

          GroupBox("Label") {
            Label(title: "Label")
              .labelStyle(.status(.positiveIcon))
          }
          .groupBoxStyle(.singleCard)
        }
      }
      .listRowInsets(.edgeInsets200)
    }
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 



private struct SingleCardLeadingSectionTestView: View {
  var body: some View {
    List {
      Section {
        VStack(spacing: .spacing200) {
          Label(
            content: { Text("Title") }, 
            item: { Icons.Outline.Symbols.star }
          )
          .labelStyle(.leading(.clickable))

          Divider()

          Label(
            content: { Text("Title") }, 
            item: { Icons.Outline.Symbols.star }
          )
          .labelStyle(.leading(.destructive))

          Divider()

          Label(
            content: { Text("Title") }, 
            item: { Icons.Outline.Symbols.star }
          )
          .labelStyle(.leading(.icon))

          Divider()

          Label(
            content: {
              GroupBox("Title") {
                Text("Label")
              }
              .groupBoxStyle(.singleCard.reversed)
            }, 
            item: { Icons.Outline.Symbols.star }
          )
          .labelStyle(.leading(.icon))

          Divider()

          Label(
            content: {
              GroupBox("Title") {
                Text("Label")
              }
              .groupBoxStyle(.singleCard.reversed)
            }, 
            item: { Icons.Outline.Symbols.star }
          )
          .labelStyle(.leading(.icon))
          .disabled(true)

          Divider()

          Label(
            content: {
              GroupBox("Title") {
                Text("Label")
              }
              .groupBoxStyle(.singleCard.reversed)
            }, 
            item: { Icons.Outline.Symbols.star }
          )
          .labelStyle(.leading(.placeholder))

          Divider()

          Label(
            content: {
              GroupBox("Title") {
                Text("Label")
              }
              .groupBoxStyle(.singleCard.reversed)
            }, 
            item: { Icons.Outline.Symbols.star }
          )
          .labelStyle(.leading(.placeholder))
          .disabled(true)

          Divider()

          Label(
            content: {
              GroupBox("Title") {
                Text("Label")
              }
              .groupBoxStyle(.singleCard.reversed)
            }, 
            item: { Icons.Lift.CardMini.attorneyAtLawCard }
          )
          .labelStyle(.leading(.custom))

          Divider()

          Label(
            content: {
              GroupBox("Title") {
                Text("Label")
              }
              .groupBoxStyle(.singleCard.reversed)
            }, 
            item: { Icons.Lift.CardMini.attorneyAtLawCard }
          )
          .labelStyle(.leading(.custom))
          .disabled(true)

          Divider()

          Label(
            content: {
              GroupBox("Title") {
                Text("Label")
              }
              .groupBoxStyle(.singleCard.reversed)
            }, 
            item: { Image.testImage }
          )
          .labelStyle(.leading(.image))

          Divider()

          Label(
            content: {
              GroupBox("Title") {
                Text("Label")
              }
              .groupBoxStyle(.singleCard.reversed)
            }, 
            item: { Image.testImage }
          )
          .labelStyle(.leading(.image))
          .disabled(true)
        }
      }
      .listRowInsets(.edgeInsets200)
    }
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 



private struct SingleCardLeadingToggleSectionTestView: View {
  @Environment(\.appTheme) private var appTheme 

  var body: some View {
    List {
      Section {
        VStack(spacing: .spacing200) {
          Toggle(isOn: .constant(true)) {
            Label(
              content: {
                GroupBox("Title") {
                  Text("Label")
                }
                .groupBoxStyle(.singleCard.reversed)
              }, 
              item: { Icons.Outline.Symbols.star }
            )
            .labelStyle(.leading(.icon))
          }
          .primaryStyle(appTheme: appTheme)
          .toggleStyle(.checkBox())

          Divider()

          Toggle(isOn: .constant(false)) {
            Label(
              content: {
                GroupBox("Title") {
                  Text("Description Description Description Description Description Description Description Description Description")
                }
                .groupBoxStyle(.singleCard.reversed)
              }, 
              item: { Icons.Outline.Symbols.star }
            )
            .labelStyle(.leading(.icon))
          }
          .primaryStyle(appTheme: appTheme)
          .toggleStyle(.checkBox())

          Divider()

          Toggle(isOn: .constant(true)) {
            Label(
              content: {
                GroupBox("Title") {
                  Text("Label")
                }
                .groupBoxStyle(.singleCard.reversed)
              }, 
              item: { Icons.Outline.Symbols.star }
            )
            .labelStyle(.leading(.icon))
          }
          .primaryStyle(appTheme: appTheme)
          .toggleStyle(.radio)

          Divider()

          Toggle(isOn: .constant(false)) {
            Label(
              content: {
                GroupBox("Title") {
                  Text("Description Description Description Description Description Description Description Description Description")
                }
                .groupBoxStyle(.singleCard.reversed)
              }, 
              item: { Icons.Outline.Symbols.star }
            )
            .labelStyle(.leading(.icon))
          }
          .primaryStyle(appTheme: appTheme)
          .toggleStyle(.radio)
        }
      }
      .listRowInsets(.edgeInsets200)
    }
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 



private struct SingleCardTopAndBottomSectionTestView: View {
  var body: some View {
    List {
      Section {
        NavigationLink(destination: EmptyView.init) {
          VStack(alignment: .leading, spacing: .spacing200) {
            Label(title: "Label")
              .labelStyle(.status(.borderedPositiveIcon))

            GroupBox("Label") {
              GroupBox("Title") {
                Text("Description")
              }
              .groupBoxStyle(.singleCard.reversed)
            }
            .groupBoxStyle(.singleCard)

            Group {
              Text("Label: ")
                .font(.footnote)
              + Text("Value")
                .font(.subheadline.weight(.semibold))
            }
            .foregroundStyle(Color.neutral500)
          }
        }
      }
      .listRowInsets(.edgeInsets200)
    }
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 



private struct SingleCardTrailingSectionTestView: View {
  var body: some View {
    List {
      Section {
        VStack(alignment: .leading, spacing: .spacing200) {
          Label(
            content: {
              GroupBox("Label") {
                Text("Title")
              }
              .groupBoxStyle(.singleCard)
            }, 
            item: {
              Button("Kopiuj") {}
                .buttonStyle(.primary(.small))
            }
          )
          .labelStyle(.trailing)

          Divider()

          Label(
            content: {
              GroupBox("Label") {
                Text("Title")
              }
              .groupBoxStyle(.singleCard)
            }, 
            item: {
              Button(
                action: {}, 
                label: { Icons.Outline.Symbols.delete }
              )
              .buttonStyle(.tertiary(.iconSmallDestructive))
            }
          )
          .labelStyle(.trailing)

          Divider()

          NavigationLink(destination: EmptyView.init) {
            GroupBox("Label") {
              Text("Title")
            }
            .groupBoxStyle(.singleCard)
          }

          Divider()

          Button(
            action: {}, 
            label: {
              GroupBox("Label") {
                Text("Title")
              }
              .groupBoxStyle(.singleCard)
            }
          )
          .buttonStyle(.navigationLink)
        }
      }
      .listRowInsets(.edgeInsets200)
    }
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 



private struct SingleCardNavigationLinkView: View {
  var body: some View {
    VStack(spacing: .spacing200) {
      VStack(alignment: .leading, spacing: .spacing200) {
        Label(title: "Lorem ipsum dolor")
          .labelStyle(.status(.borderedPositiveIcon))

        GroupBox("Fusce vitae ligula eget libero pulvinar semper") {
          Text("Integer ornare lacus sit amet justo egestas tristique")
        }
        .groupBoxStyle(.singleCard.reversed)

        Text("Pellentesque rhoncus ultricies diam ac accumsan")
          .font(.subheadline.weight(.semibold))
          .foregroundStyle(Color.neutral500)
      }
      .navigationLinkStyle()
      .contentBox()

      Spacer()
    }
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

private extension Image {
  static var testImage: some View {
    Image("test_image", bundle: .module)
      .resizable()
  }
}
