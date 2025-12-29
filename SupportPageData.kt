/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.supportpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.button.Button
import pl.gov.coi.common.ui.ds.contentbox.ContentBox
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.supportpage.provider.SupportPagePreviewParameterProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.topMenu.TopMenu
import pl.gov.coi.common.ui.ds.inforow.InfoRowList
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData

@Deprecated("Use BaseScaffold with Header")
@Composable
fun <CONTENT_DATA> SupportPage(
  data: SupportPageData<CONTENT_DATA>,
  content: @Composable (CONTENT_DATA) -> Unit = {},
) {
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = {
      TopMenu(
        label = data.topBarTitle,
        menuButtonData = data.menuButtonData,
        mainButtonData = data.mainButtonData,
      )
    },
  ) { contentPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(color = AppTheme.colors.background)
        .padding(
          top = contentPadding.calculateTopPadding(),
          start = AppTheme.dimensions.spacing250,
          end = AppTheme.dimensions.spacing250,
        ),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f)
          .background(color = AppTheme.colors.background)
          .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
        Icon(data = data.iconData)
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing300))
        CustomText(
          label = data.title,
          modifier = Modifier
            .padding(horizontal = AppTheme.dimensions.spacing250)
            .align(alignment = Alignment.CenterHorizontally),
          style = AppTheme.typography.headlineMedium,
          textAlign = TextAlign.Center,
        )
        data.message?.let {
          Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing300))
          CustomText(
            label = it,
            modifier = Modifier
              .padding(horizontal = AppTheme.dimensions.spacing250)
              .align(alignment = Alignment.CenterHorizontally),
            style = AppTheme.typography.bodyLargeRegular,
            color = AppTheme.colors.neutral200,
            textAlign = TextAlign.Center,
          )
        }
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing600))
        content(data.contentData)
      }

      data.buttonData?.let {
        Column(
          modifier = Modifier
            .background(color = AppTheme.colors.background)
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(
              top = AppTheme.dimensions.spacing300,
              bottom = AppTheme.dimensions.spacing300,
            ),
          verticalArrangement = Arrangement.Bottom,
        ) {
          Button(data = it)
        }
      }
    }
  }
}

@Preview
@Composable
fun SupportPagePreview(@PreviewParameter(SupportPagePreviewParameterProvider::class) data: SupportPageData<*>) {
  SupportPage(data = data) {
    if (it is InfoRowListData) {
      ContentBox {
        InfoRowList(data = it)
      }
    }
  }
}
