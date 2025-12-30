/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.supportpage.provider

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
import pl.gov.coi.common.ui.ds.supportpage.SupportPageData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class SupportPagePreviewParameterProvider : CustomPreviewParameterProvider<SupportPageData<*>>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<SupportPageData<*>>>
    get() = sequenceOf(
      ScreenShotTestData(
        screenShotTestName = "SupportPageData",
        value = SupportPageData(
          topBarTitle = "Top bar title".toLabel(),
          topBarIconMainResId = null,
          onTopBarIconMainClick = null,
          topBarIconMenuResId = null,
          onTopBarIconMenuClick = null,
          iconResId = R.drawable.ag005_globe,
          iconContentDescription = Label.EMPTY,
          title = "Title Size XXL medium 24 Color - black 900".toLabel(),
          message = "Description text Size - M, Color - grey 900".toLabel(),
          contentData = Unit,
          buttonData = null,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = "SupportPageDataExample",
        value = SupportPageData(
          topBarTitle = "Wybierz język".toLabel(),
          topBarIconMainResId = R.drawable.ab004_arrow_left,
          onTopBarIconMainClick = {},
          topBarIconMenuResId = null,
          onTopBarIconMenuClick = null,
          iconResId = R.drawable.ag005_globe,
          iconContentDescription = Label.EMPTY,
          title = "Top bar title".toLabel(),
          message = "Nie można zmienić języka w Ustawieniach.".toLabel(),
          contentData = InfoRowListData(
            items = listOf(
              InfoRowData.Bullet(
                description = "Support text\nSIZE M: Roboto Normal Gray 900".toLabel(),
              ),
              InfoRowData.Bullet(
                description = "Support text\nSIZE M: Roboto Normal Gray 900".toLabel(),
              ),
            ),
          ),
          buttonData = ButtonData(
            buttonSize = ButtonSize.Large(),
            buttonVariant = ButtonVariant.Primary,
            buttonType = ButtonType.WithText(
              label = "Dalej".toLabel(),
            ),
            onClick = {},
          ),
        ),
      ),
    )
}
