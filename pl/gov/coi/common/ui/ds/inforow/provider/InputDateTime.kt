/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.inforow.provider

import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.theme.AppTheme

class InfoRowPPP : CustomPreviewParameterProvider<InfoRowListData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<InfoRowListData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "InfoRowBullet",
      value = InfoRowListData(
        listOf(
          InfoRowData.Bullet(
            description = ("Bullet info row description Bullet info row description " +
              "Bullet info row description Bullet info row description Bullet info row description " +
              "Bullet info row description Bullet info row description ").toLabel(),
          ),
          InfoRowData.Bullet(
            description = "Bullet info row description".toLabel(),
          ),
        ),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "InfoRowDefault",
      value = InfoRowListData(
        listOf(
          InfoRowData.Default(
            title = "Title label 1".toLabel(),
            description = ("Description label 1 Description label 1 Description label 1 " +
              "Description label 1 Description label 1").toLabel(),
            iconResId = R.drawable.aa037_rounded_plus,
            iconColorProvider = { AppTheme.colors.supportGreen100 },
          ),
          InfoRowData.Default(
            title = "Title label 2".toLabel(),
            description = "Description label 2".toLabel(),
            iconResId = R.drawable.aa002_delete,
            iconColorProvider = { AppTheme.colors.supportRed100 },
          ),
        ),
      ),
    ),
  )
}
