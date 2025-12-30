/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

extension ToggleStyle where Self == CheckBoxToggleStyle {
  public static func checkBox(_ alignment: VerticalAlignment = .center) -> Self {
    .init(alignment: alignment)
  }
}

public struct CheckBoxToggleStyle: ToggleStyle {
  private let alignment: VerticalAlignment
  @Environment(\.isValid) private var isValid
  @Environment(\.isEnabled) private var isEnabled
  @Environment(\.appTheme) private var appTheme

  public init(alignment: VerticalAlignment = .center) {
    self.alignment = alignment 
  }

  public func makeBody(configuration: Configuration) -> some View {
    HStack(alignment: alignment, spacing: .spacing200) {
      Group {
        if configuration.isOn {
          selectedContent 
        } else {
          unselectedContent 
        }
      }
      .frame(size: .spacing250)
      .padding(.spacing25)
      .shadow(.light200)

      configuration.label
        .foregroundStyle(Color.neutral500)
        .frame(minHeight: .spacing300)

      Spacer(minLength: .zero)
    }
    .frame(maxWidth: .infinity)
    .contentShape(.rect)
    .onTapGesture { configuration.isOn.toggle() }
  }
} 

private extension CheckBoxToggleStyle {
  var selectedContent: some View {
    Icons.Dedicated.checkboxMark
      .resizable()
      .frame(size: Constants.iconSize)
      .aspectRatio(contentMode: .fit)
      .foregroundStyle(Color.white)
      .padding(.spacing50)
      .background(selectedBackgroundColor)
      .cornerRadius(.radius50)
  }

  var unselectedContent: some View {
    RoundedRectangle(cornerRadius: .radius50)
      .strokeBorder(borderColor, lineWidth: Constants.strokeWidth)
  }

  var selectedBackgroundColor: Color {
    guard isValid else { return .red100 }
    return isEnabled ? appTheme.colors.primary900 : .neutral30
  }

  var borderColor: Color {
    guard isValid else { return .red100 }
    return isEnabled ? .neutral80 : .neutral30
  }
}

private enum Constants {
  static let strokeWidth = 2.0
  static let iconSize = 12.0
}
