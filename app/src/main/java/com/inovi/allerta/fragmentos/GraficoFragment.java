package com.inovi.allerta.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.inovi.allerta.R;

public class GraficoFragment extends Fragment {
    private WebView wvGrafico;
    private String strURL;
    private String strURL2;
    private String strURL3;
    private String strURL4;
    private View rootView;
    private WebView wvGraficoDia;
    private WebView wvGraficoArea;
    private WebView wvGraficoMes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.rootView = inflater.inflate(R.layout.fragment_graficos, container, false);

        strURL = "https://chart.googleapis.com/chart?" +
                "cht=lc&" + //define o tipo do gráfico "linha"
                "chxt=x,y&" + //imprime os valores dos eixos X, Y
                "chs=360x400&" + //define o tamanho da imagem
                "chd=t:10,45,5,10,13,26&" + //valor de cada coluna do gráfico
                "chl=Jan|Fev|Mar|Abr|Mai|Jun|Jul&" + //rótulo para cada coluna
                "chdl=precipitação +(mm)&" + //legenda do gráfico
                "chxr=1,0,50&" + //define o valor de início e fim do eixo
                "chds=0,50&" + //define o valor de escala dos dados
                "chg=0,5,0,0&" + //desenha linha horizontal na grade
                "chco=3D7930&" + //cor da linha do gráfico
                "chtt=Chuvas x Ano&" + //cabeçalho do gráfico
                "chm=B,C5D4B5BB,0,0,0"; //fundo verde

        strURL2 = "https://chart.googleapis.com/chart?" +
                "cht=lc&" + //define o tipo do gráfico "linha"
                "chxt=x,y&" + //imprime os valores dos eixos X, Y
                "chs=360x400&" + //define o tamanho da imagem
                "chd=t:10,15,5,10,3,16&" + //valor de cada coluna do gráfico
                "chl=00:00|06:00|12:00|16:00|20:00&" + //rótulo para cada coluna
                "chdl=precipitação +(mm)&" + //legenda do gráfico
                "chxr=1,0,50&" + //define o valor de início e fim do eixo
                "chds=0,50&" + //define o valor de escala dos dados
                "chg=0,5,0,0&" + //desenha linha horizontal na grade
                "chco=3D7930&" + //cor da linha do gráfico
                "chtt=Chuvas x Dia&" + //cabeçalho do gráfico
                "chm=B,C5D4B5BB,0,0,0"; //fundo verde

        strURL3 = "https://chart.googleapis.com/chart?" +
                "cht=lc&" + //define o tipo do gráfico "linha"
                "chxt=x,y&" + //imprime os valores dos eixos X, Y
                "chs=360x400&" + //define o tamanho da imagem
                "chd=t:20,25,35,10,13,36&" + //valor de cada coluna do gráfico
                "chl=Area1|Area2|Area3|Area4&" + //rótulo para cada coluna
                "chdl=precipitação +(mm)&" + //legenda do gráfico
                "chxr=1,0,50&" + //define o valor de início e fim do eixo
                "chds=0,50&" + //define o valor de escala dos dados
                "chg=0,5,0,0&" + //desenha linha horizontal na grade
                "chco=3D7930&" + //cor da linha do gráfico
                "chtt=Chuvas x Area&" + //cabeçalho do gráfico
                "chm=B,C5D4B5BB,0,0,0"; //fundo verde

        strURL4 = "https://chart.googleapis.com/chart?" +
                "cht=lc&" + //define o tipo do gráfico "linha"
                "chxt=x,y&" + //imprime os valores dos eixos X, Y
                "chs=360x400&" + //define o tamanho da imagem
                "chd=t:4,5,15,20,23,6&" + //valor de cada coluna do gráfico
                "chl=1|5|10|15|20|25|30&" + //rótulo para cada coluna
                "chdl=precipitação +(mm)&" + //legenda do gráfico
                "chxr=1,0,50&" + //define o valor de início e fim do eixo
                "chds=0,50&" + //define o valor de escala dos dados
                "chg=0,5,0,0&" + //desenha linha horizontal na grade
                "chco=3D7930&" + //cor da linha do gráfico
                "chtt=Chuvas x Mês&" + //cabeçalho do gráfico
                "chm=B,C5D4B5BB,0,0,0"; //fundo verde


        wvGrafico = (WebView) this.rootView.findViewById(R.id.wvGrafico);
        wvGraficoDia = (WebView) this.rootView.findViewById(R.id.wvGraficoDia);
        wvGraficoArea = (WebView) this.rootView.findViewById(R.id.wvGraficoArea);
        wvGraficoMes = (WebView) this.rootView.findViewById(R.id.wvGraficoMes);

        wvGrafico.loadUrl(strURL);
        wvGraficoDia.loadUrl(strURL2);
        wvGraficoArea.loadUrl(strURL3);
        wvGraficoMes.loadUrl(strURL4);
        return  this.rootView;
    }
}
