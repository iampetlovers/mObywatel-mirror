/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.statusbadge

import pl.gov.coi.common.domain.label.Label

sealed class StatusBadgeData(
  open val testTag: String?,
  open val label: Label,
  open val withBorder: Boolean = false,
  open val contentDescription: Label = Label.EMPTY,
  open val maxLines: Int,
) {
  data class WithDot(
    override val testTag: String? = null,
    override val label: Label,
    override val contentDescription: Label = Label.EMPTY,
    override val maxLines: Int = Int.MAX_VALUE,
    val status: StatusBadgeWithDotStatus,
  ) : StatusBadgeData(
    testTag = testTag,
    label = label,
    withBorder = false,
    maxLines = maxLines,
  )

  data class WithIcon(
    override val testTag: String? = null,
    override val label: Label,
    override val contentDescription: Label = Label.EMPTY,
    override val maxLines: Int = Int.MAX_VALUE,
    override val withBorder: Boolean = true,
    val status: StatusBadgeWithIconStatus,
  ) : StatusBadgeData(
    testTag = testTag,
    label = label,
    withBorder = withBorder,
    maxLines = maxLines,
  )
}

enum class StatusBadgeWithIconStatus {
  POSITIVE,
  INFORMATIVE,
  NEGATIVE,
  NOTICE,
  MINUS,
}

enum class StatusBadgeWithDotStatus {
  POSITIVE,
  INFORMATIVE,
  NEGATIVE,
  WARNING,
}
