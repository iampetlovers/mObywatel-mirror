/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.custom.documentrow.provider

import android.content.Context
import androidx.compose.ui.res.colorResource
import pl.gov.coi.common.domain.Mapper
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.custom.documentrow.DocumentRowData
import pl.gov.coi.common.ui.ds.statusbadge.StatusBadgeData
import pl.gov.coi.common.ui.ds.statusbadge.StatusBadgeWithIconStatus
import pl.gov.coi.common.ui.preview.CustomWrappedDataPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestDataProvider
import pl.gov.coi.common.ui.preview.WrappedValue

data class ProvidedSingleCardDocumentRowData(
  val previewName: String,
  val data: DocumentRowData,
)

class SingleCardDocumentRowPPP : CustomWrappedDataPreviewParameterProvider
  <Unit, DocumentRowData, Mapper<Unit, DocumentRowData>, ProvidedSingleCardDocumentRowData>() {

  override fun mapper(context: Context): Mapper<Unit, DocumentRowData> {
    return object : Mapper<Unit, DocumentRowData> {
      override fun invoke(p1: Unit): DocumentRowData = getSingleCardDocument()
    }
  }

  private val cards = mapOf(
    "SingleCardDocumentRow" to getSingleCardDocument(),
    "SingleCardDocumentRowWithDescription" to getSingleCardDocumentWithDescription(),
    "SingleCardDocumentRowWithStatus" to getSingleCardDocumentWithStatus(),
    "SingleCardDocumentRowWithDescriptionStatus" to getSingleCardDocumentWithDescriptionStatus(),
  )

  override val screenShotTestValues: Sequence<ScreenShotTestDataProvider<ProvidedSingleCardDocumentRowData>>
    get() = cards.map { (testName, cardData) ->
      ScreenShotTestDataProvider(
        screenShotTestName = testName,
        wrappedValue = WrappedValue {
          ProvidedSingleCardDocumentRowData(
            previewName = testName,
            data = cardData,
          )
        },
      )
    }.asSequence()

  private fun getSingleCardDocument() = DocumentRowData(
    title = "Legitymacja poselska".toLabel(),
    iconColorProvider = { colorResource(id = R.color.coi_mobywatel_feature_dashboard_deputy_card_primary) },
    iconResId = R.drawable.db012_legitymacja_poselska,
    badgeData = null,
    onClick = {},
  )

  private fun getSingleCardDocumentWithDescription() = getSingleCardDocument().copy(
    description = "Opis dokumentu".toLabel(),
  )

  private fun getSingleCardDocumentWithStatus() = getSingleCardDocument().copy(
    badgeData = StatusBadgeData.WithIcon(
      label = "Błąd pobierania".toLabel(),
      withBorder = false,
      status = StatusBadgeWithIconStatus.NEGATIVE,
    ),
  )

  private fun getSingleCardDocumentWithDescriptionStatus() = getSingleCardDocumentWithDescription().copy(
    badgeData = StatusBadgeData.WithIcon(
      label = "Błąd pobierania".toLabel(),
      withBorder = false,
      status = StatusBadgeWithIconStatus.NEGATIVE,
    ),
  )
}
