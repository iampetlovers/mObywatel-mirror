/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

import SwiftUI

public struct SmallDocumentCard<LeadingItem: View>: View {
  private let title: String
  private let backgroundImage: Image
  private let leadingItem: LeadingItem

  public init( 
    title: String,
    backgroundImage: Image,
    @ViewBuilder leadingItem: () -> LeadingItem
  ) {
    self.leadingItem = leadingItem()
    self.title = title 
    self.backgroundImage = backgroundImage 
  }

  public var body: some View {
    VStack(alignment: .leading) {
      leadingItem 
        .frame(size: Constants.spacing450, alignment: .leading)

      Spacer()

      Text(title)
        .font(.subheadline.weight(.semibold))
        .foregroundStyle(Color.white)
        .multilineTextAlignment(.leading)
        .lineLimit(Constants.lineLimit)
        .frame(maxWidth: .infinity, alignment: .leading)
    }
    .padding(.spacing200)
    .aspectRatio(Constants.aspectRatio, contentMode: .fit)
    .background(backgroundImage.resizable().aspectRatio(contentMode: .fill))
    .clipShape(.rect(cornerRadius: .radius200))
    .shadow(.light600)
  }
} 

private enum Constants {
  static let aspectRatio = 1.0
  static let spacing450 = 36.0
  static let lineLimit = 3
}
