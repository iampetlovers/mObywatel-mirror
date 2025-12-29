/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.iconpage

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme

data class IconPageData<CONTENT, BOTTOM_CONTENT>(
  val iconSection: IconSection,
  val title: Label,
  val descriptionFirst: Label? = null,
  val descriptionSecond: Label? = null,
  val content: CONTENT?,
  val bottomContent: BOTTOM_CONTENT?,
)

sealed class IconSection(
  val icon: IconData,
) {

  class Empty(
    iconRes: Int = R.drawable.g002_document_box_big,
  ) : IconSection(
    icon = IconData.Standard(
      iconResId = iconRes,
      iconSize = IconSize.SIZE96,
      iconColorProvider = { AppTheme.colors.primary900 },
      contentDescription = null,
    ),
  )

  sealed class Result(
    val iconResId: Int,
    val iconColorProvider: @Composable () -> Color,
  ) : IconSection(
    icon = IconData.Standard(
      iconResId = iconResId,
      iconSize = IconSize.SIZE64,
      iconColorProvider = iconColorProvider,
      contentDescription = null,
    ),
  ) {
    data object Info : Result(
      iconResId = R.drawable.f1_info,
      iconColorProvider = { AppTheme.colors.supportBlue100 },
    )

    data object Warning : Result(
      iconResId = R.drawable.f2_warning_mark,
      iconColorProvider = { AppTheme.colors.supportOrange100 },
    )

    data object Failure : Result(
      iconResId = R.drawable.f3_failure,
      iconColorProvider = { AppTheme.colors.supportRed100 },
    )

    data object Success : Result(
      iconResId = R.drawable.f4_success,
      iconColorProvider = { AppTheme.colors.supportGreen100 },
    )
  }
}
