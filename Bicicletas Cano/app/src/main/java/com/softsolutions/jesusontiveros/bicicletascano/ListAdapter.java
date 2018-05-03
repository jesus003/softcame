package com.softsolutions.jesusontiveros.bicicletascano;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListAdapter extends BaseAdapter {

    Context context;
    private final String [] values;
    private final String [] numbers;
    private final String [] images;

    public ListAdapter(Context context, String [] values, String [] numbers, String [] images){
        //super(context, R.layout.single_list_app_item, utilsArrayList);
        this.context = context;
        this.values = values;
        this.numbers = numbers;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.single_list_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.aNametxt);
            viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.aVersiontxt);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.appIconIV);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txtName.setText(values[position]);
        viewHolder.txtVersion.setText(""+numbers[position]);
        byte[] imageBytes ;
        String ss = "/9j/4RWxRXhpZgAATU0AKgAAAAgABwESAAMAAAABAAEAAAEaAAUAAAABAAAAYgEbAAUAAAABAAAA\n" +
                "agEoAAMAAAABAAIAAAExAAIAAAAeAAAAcgEyAAIAAAAUAAAAkIdpAAQAAAABAAAApAAAANAACvyA\n" +
                "AAAnEAAK/IAAACcQQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykAMjAxODowMzoxOSAxNDo1\n" +
                "NzoxNQAAA6ABAAMAAAAB//8AAKACAAQAAAABAAAAUKADAAQAAAABAAAAUAAAAAAAAAAGAQMAAwAA\n" +
                "AAEABgAAARoABQAAAAEAAAEeARsABQAAAAEAAAEmASgAAwAAAAEAAgAAAgEABAAAAAEAAAEuAgIA\n" +
                "BAAAAAEAABR7AAAAAAAAAEgAAAABAAAASAAAAAH/2P/iDFhJQ0NfUFJPRklMRQABAQAADEhMaW5v\n" +
                "AhAAAG1udHJSR0IgWFlaIAfOAAIACQAGADEAAGFjc3BNU0ZUAAAAAElFQyBzUkdCAAAAAAAAAAAA\n" +
                "AAABAAD21gABAAAAANMtSFAgIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                "AAAAAAAAAAAAEWNwcnQAAAFQAAAAM2Rlc2MAAAGEAAAAbHd0cHQAAAHwAAAAFGJrcHQAAAIEAAAA\n" +
                "FHJYWVoAAAIYAAAAFGdYWVoAAAIsAAAAFGJYWVoAAAJAAAAAFGRtbmQAAAJUAAAAcGRtZGQAAALE\n" +
                "AAAAiHZ1ZWQAAANMAAAAhnZpZXcAAAPUAAAAJGx1bWkAAAP4AAAAFG1lYXMAAAQMAAAAJHRlY2gA\n" +
                "AAQwAAAADHJUUkMAAAQ8AAAIDGdUUkMAAAQ8AAAIDGJUUkMAAAQ8AAAIDHRleHQAAAAAQ29weXJp\n" +
                "Z2h0IChjKSAxOTk4IEhld2xldHQtUGFja2FyZCBDb21wYW55AABkZXNjAAAAAAAAABJzUkdCIElF\n" +
                "QzYxOTY2LTIuMQAAAAAAAAAAAAAAEnNSR0IgSUVDNjE5NjYtMi4xAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABYWVogAAAAAAAA81EAAQAAAAEWzFhZWiAA\n" +
                "AAAAAAAAAAAAAAAAAAAAWFlaIAAAAAAAAG+iAAA49QAAA5BYWVogAAAAAAAAYpkAALeFAAAY2lhZ\n" +
                "WiAAAAAAAAAkoAAAD4QAALbPZGVzYwAAAAAAAAAWSUVDIGh0dHA6Ly93d3cuaWVjLmNoAAAAAAAA\n" +
                "AAAAAAAWSUVDIGh0dHA6Ly93d3cuaWVjLmNoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                "AAAAAAAAAAAAAAAAAAAAAGRlc2MAAAAAAAAALklFQyA2MTk2Ni0yLjEgRGVmYXVsdCBSR0IgY29s\n" +
                "b3VyIHNwYWNlIC0gc1JHQgAAAAAAAAAAAAAALklFQyA2MTk2Ni0yLjEgRGVmYXVsdCBSR0IgY29s\n" +
                "b3VyIHNwYWNlIC0gc1JHQgAAAAAAAAAAAAAAAAAAAAAAAAAAAABkZXNjAAAAAAAAACxSZWZlcmVu\n" +
                "Y2UgVmlld2luZyBDb25kaXRpb24gaW4gSUVDNjE5NjYtMi4xAAAAAAAAAAAAAAAsUmVmZXJlbmNl\n" +
                "IFZpZXdpbmcgQ29uZGl0aW9uIGluIElFQzYxOTY2LTIuMQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                "AAAAdmlldwAAAAAAE6T+ABRfLgAQzxQAA+3MAAQTCwADXJ4AAAABWFlaIAAAAAAATAlWAFAAAABX\n" +
                "H+dtZWFzAAAAAAAAAAEAAAAAAAAAAAAAAAAAAAAAAAACjwAAAAJzaWcgAAAAAENSVCBjdXJ2AAAA\n" +
                "AAAABAAAAAAFAAoADwAUABkAHgAjACgALQAyADcAOwBAAEUASgBPAFQAWQBeAGMAaABtAHIAdwB8\n" +
                "AIEAhgCLAJAAlQCaAJ8ApACpAK4AsgC3ALwAwQDGAMsA0ADVANsA4ADlAOsA8AD2APsBAQEHAQ0B\n" +
                "EwEZAR8BJQErATIBOAE+AUUBTAFSAVkBYAFnAW4BdQF8AYMBiwGSAZoBoQGpAbEBuQHBAckB0QHZ\n" +
                "AeEB6QHyAfoCAwIMAhQCHQImAi8COAJBAksCVAJdAmcCcQJ6AoQCjgKYAqICrAK2AsECywLVAuAC\n" +
                "6wL1AwADCwMWAyEDLQM4A0MDTwNaA2YDcgN+A4oDlgOiA64DugPHA9MD4APsA/kEBgQTBCAELQQ7\n" +
                "BEgEVQRjBHEEfgSMBJoEqAS2BMQE0wThBPAE/gUNBRwFKwU6BUkFWAVnBXcFhgWWBaYFtQXFBdUF\n" +
                "5QX2BgYGFgYnBjcGSAZZBmoGewaMBp0GrwbABtEG4wb1BwcHGQcrBz0HTwdhB3QHhgeZB6wHvwfS\n" +
                "B+UH+AgLCB8IMghGCFoIbgiCCJYIqgi+CNII5wj7CRAJJQk6CU8JZAl5CY8JpAm6Cc8J5Qn7ChEK\n" +
                "Jwo9ClQKagqBCpgKrgrFCtwK8wsLCyILOQtRC2kLgAuYC7ALyAvhC/kMEgwqDEMMXAx1DI4MpwzA\n" +
                "DNkM8w0NDSYNQA1aDXQNjg2pDcMN3g34DhMOLg5JDmQOfw6bDrYO0g7uDwkPJQ9BD14Peg+WD7MP\n" +
                "zw/sEAkQJhBDEGEQfhCbELkQ1xD1ERMRMRFPEW0RjBGqEckR6BIHEiYSRRJkEoQSoxLDEuMTAxMj\n" +
                "E0MTYxODE6QTxRPlFAYUJxRJFGoUixStFM4U8BUSFTQVVhV4FZsVvRXgFgMWJhZJFmwWjxayFtYW\n" +
                "+hcdF0EXZReJF64X0hf3GBsYQBhlGIoYrxjVGPoZIBlFGWsZkRm3Gd0aBBoqGlEadxqeGsUa7BsU\n" +
                "GzsbYxuKG7Ib2hwCHCocUhx7HKMczBz1HR4dRx1wHZkdwx3sHhYeQB5qHpQevh7pHxMfPh9pH5Qf\n" +
                "vx/qIBUgQSBsIJggxCDwIRwhSCF1IaEhziH7IiciVSKCIq8i3SMKIzgjZiOUI8Ij8CQfJE0kfCSr\n" +
                "JNolCSU4JWgllyXHJfcmJyZXJocmtyboJxgnSSd6J6sn3CgNKD8ocSiiKNQpBik4KWspnSnQKgIq\n" +
                "NSpoKpsqzysCKzYraSudK9EsBSw5LG4soizXLQwtQS12Last4S4WLkwugi63Lu4vJC9aL5Evxy/+\n" +
                "MDUwbDCkMNsxEjFKMYIxujHyMioyYzKbMtQzDTNGM38zuDPxNCs0ZTSeNNg1EzVNNYc1wjX9Njc2\n" +
                "cjauNuk3JDdgN5w31zgUOFA4jDjIOQU5Qjl/Obw5+To2OnQ6sjrvOy07azuqO+g8JzxlPKQ84z0i\n" +
                "PWE9oT3gPiA+YD6gPuA/IT9hP6I/4kAjQGRApkDnQSlBakGsQe5CMEJyQrVC90M6Q31DwEQDREdE\n" +
                "ikTORRJFVUWaRd5GIkZnRqtG8Ec1R3tHwEgFSEtIkUjXSR1JY0mpSfBKN0p9SsRLDEtTS5pL4kwq\n" +
                "THJMuk0CTUpNk03cTiVObk63TwBPSU+TT91QJ1BxULtRBlFQUZtR5lIxUnxSx1MTU19TqlP2VEJU\n" +
                "j1TbVShVdVXCVg9WXFapVvdXRFeSV+BYL1h9WMtZGllpWbhaB1pWWqZa9VtFW5Vb5Vw1XIZc1l0n\n" +
                "XXhdyV4aXmxevV8PX2Ffs2AFYFdgqmD8YU9homH1YklinGLwY0Njl2PrZEBklGTpZT1lkmXnZj1m\n" +
                "kmboZz1nk2fpaD9olmjsaUNpmmnxakhqn2r3a09rp2v/bFdsr20IbWBtuW4SbmtuxG8eb3hv0XAr\n" +
                "cIZw4HE6cZVx8HJLcqZzAXNdc7h0FHRwdMx1KHWFdeF2Pnabdvh3VnezeBF4bnjMeSp5iXnnekZ6\n" +
                "pXsEe2N7wnwhfIF84X1BfaF+AX5ifsJ/I3+Ef+WAR4CogQqBa4HNgjCCkoL0g1eDuoQdhICE44VH\n" +
                "hauGDoZyhteHO4efiASIaYjOiTOJmYn+imSKyoswi5aL/IxjjMqNMY2Yjf+OZo7OjzaPnpAGkG6Q\n" +
                "1pE/kaiSEZJ6kuOTTZO2lCCUipT0lV+VyZY0lp+XCpd1l+CYTJi4mSSZkJn8mmia1ZtCm6+cHJyJ\n" +
                "nPedZJ3SnkCerp8dn4uf+qBpoNihR6G2oiailqMGo3aj5qRWpMelOKWpphqmi6b9p26n4KhSqMSp\n" +
                "N6mpqhyqj6sCq3Wr6axcrNCtRK24ri2uoa8Wr4uwALB1sOqxYLHWskuywrM4s660JbSctRO1irYB\n" +
                "tnm28Ldot+C4WbjRuUq5wro7urW7LrunvCG8m70VvY++Cr6Evv+/er/1wHDA7MFnwePCX8Lbw1jD\n" +
                "1MRRxM7FS8XIxkbGw8dBx7/IPci8yTrJuco4yrfLNsu2zDXMtc01zbXONs62zzfPuNA50LrRPNG+\n" +
                "0j/SwdNE08bUSdTL1U7V0dZV1tjXXNfg2GTY6Nls2fHadtr724DcBdyK3RDdlt4c3qLfKd+v4Dbg\n" +
                "veFE4cziU+Lb42Pj6+Rz5PzlhOYN5pbnH+ep6DLovOlG6dDqW+rl63Dr++yG7RHtnO4o7rTvQO/M\n" +
                "8Fjw5fFy8f/yjPMZ86f0NPTC9VD13vZt9vv3ivgZ+Kj5OPnH+lf65/t3/Af8mP0p/br+S/7c/23/\n" +
                "///tAAxBZG9iZV9DTQAC/+4ADkFkb2JlAGSAAAAAAf/bAIQADAgICAkIDAkJDBELCgsRFQ8MDA8V\n" +
                "GBMTFRMTGBEMDAwMDAwRDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAENCwsNDg0QDg4QFA4O\n" +
                "DhQUDg4ODhQRDAwMDAwREQwMDAwMDBEMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwM/8AAEQgA\n" +
                "UABQAwEiAAIRAQMRAf/dAAQABf/EAT8AAAEFAQEBAQEBAAAAAAAAAAMAAQIEBQYHCAkKCwEAAQUB\n" +
                "AQEBAQEAAAAAAAAAAQACAwQFBgcICQoLEAABBAEDAgQCBQcGCAUDDDMBAAIRAwQhEjEFQVFhEyJx\n" +
                "gTIGFJGhsUIjJBVSwWIzNHKC0UMHJZJT8OHxY3M1FqKygyZEk1RkRcKjdDYX0lXiZfKzhMPTdePz\n" +
                "RieUpIW0lcTU5PSltcXV5fVWZnaGlqa2xtbm9jdHV2d3h5ent8fX5/cRAAICAQIEBAMEBQYHBwYF\n" +
                "NQEAAhEDITESBEFRYXEiEwUygZEUobFCI8FS0fAzJGLhcoKSQ1MVY3M08SUGFqKygwcmNcLSRJNU\n" +
                "oxdkRVU2dGXi8rOEw9N14/NGlKSFtJXE1OT0pbXF1eX1VmZ2hpamtsbW5vYnN0dXZ3eHl6e3x//a\n" +
                "AAwDAQACEQMRAD8A8+SSSVxrKSSSSUpJJJJSkkkklKSSSSU//9Dz5JJJXGspMSAJOgCdJJTv4f1C\n" +
                "+t2bjV5eP08+jc0PrL7K2EtOrX+m9+/3Ip/xcfXMODTgsDnfRByKZMeH6RH+rvWvrz1g4/1b6Xnv\n" +
                "rpY0A3Brd1NDdN9mTHq7K/oVe7f/AIJXOt/UmrBb1zqJ6llW39GFD8e6wy91j2stPqW/T+k9np+n\n" +
                "sUZkQaJH2MgjEiwC8VfVZj3W0XDZZQ91drZ4cw7Htn+S4Ie9kTOnj2V3AzMpnVqM1tQzss3iwU2t\n" +
                "NnrWuP0LGfSsda93+eu56d9Y/wDGJ1TNycHE6VhNfibftOLdV6YqD/5pj/Uua73sb+anGRHb7Voi\n" +
                "C+dAgiRqPFOup/xiY3TcbrOO3EZRTmOx2u6pRimaWZE/mDTY539Vns9OxcsiDYtBFGn/0fPSQASd\n" +
                "AOSuow/qXXRgV9U+tGeOi4l2tFBbvyrO/tp19P8AzLbP9J6an/i66ViZnWL+o57d+H0ak5TmRINn\n" +
                "u9HcP+C9Oy3/AIz01g9Y6zmdc6jb1PMcXWXH9GydK6/8FRV+6xjf89/6RWiSTQ0rcsAAAs6vRVY3\n" +
                "+Kq1/onL6nQToMmwQwH9522p/wD57VXrn1MswszBp6PmV9Yq6q4tw/TLRZIAc42hhdX6LWu9+R+Z\n" +
                "/hFnYH1Z+sPUsYZeB0+7IxnEhtrNoaS07X7d7mbtrvavQfq10Ppf1L6ccnquZi4P1g6jU7033kFt\n" +
                "I7VMZuZ6ux212S5rv0ln6NMkeHaV+G64C9xTHpbsP6p9T6X9U+mvbd1XOuZb1nLAmGBr7W47Z+hv\n" +
                "a39C3/BUfpf5zIRPrllD/mp9ZLnQ03Z7McHxFf2Sn/0VYqn1S+rnSW/WqrqbPrHR1jNb6t1lLGje\n" +
                "9z2uY+4uFtn0PU/dWw63olX1Xs6t1n34jOoZGdXUD/O2jIvGJTs/w272fo/of6T9EmHcHfb7V3St\n" +
                "nH/xf/V7C6NkYPUOtezq/Vd7el4jh7q62sNtt72/mXWVf9tMf6X85aszrjvq/wBG6znZPVrLusdX\n" +
                "y7XWXYOLc6nHpYT+hoyslm222xlXp/ov/Akb6rdYyuqdW679cOoMFuT0vCc7DxySWVBwteypn9Vl\n" +
                "Wx9n/DXWKrm4f1V+t9x6pgdSq6J1TIh+Zg5mlTrI991V0s+n+8z+d/0VdidrxHivxpGlaUgo+sf1\n" +
                "Gyh9m6l9W2YdLtDlYjy6xk/4TRtNrtv9az+os/62fVj9g5FFmNd9s6Xns9XBytJLdHelZt9u9rHt\n" +
                "e2z/AAtax8vHGLl3Yzbq8gUvLBfSd1b4/Pqd+cxdd1l+3/Fb0GrI/n35LnY08ippyP8Ao+k6tPrh\n" +
                "IrY6Utuwb6dX/9LK/wAXHV8DC6pldO6k4V4fWKfs5sJhosG4Ma9/5nqstsZu/wBJsVTr31D+sHRM\n" +
                "h7GYtmbhNP6LKoaXyz831q2TZVZ+/wC3YudIBkHUHstnpv1w+tHS6204XUbW0sEMqs22taP3WC9t\n" +
                "m1WSDdjruCwAiqLe+rvTPr/kbcLpDs3BxS4kve59FDCfpv8AfG7+pSxC+u2Jh4nUaaWdVu611Ble\n" +
                "zqF9zg9rHiPTppf7tvNm+nc/0v66q9R+uH1o6nW6rM6lc6pwh1VcVNI8HChte5Y4AAgCB4IgG7Nf\n" +
                "RRkKofi999Rsr6j9Csq6tkdYeOoWY5ruxrKnBtbnlj7Gs9Op+7Z6exr/AFPeua+stmA3IrxOldVv\n" +
                "6p05m61rbQ5rKrbHOdY2mtwrb7t35tax0khHW7JUZaVT0v1C6/g9I6nfj9Uj9m9Uq+zZLjww6+m+\n" +
                "z/gnNssqs/ro/V/8WfXcWwv6UxvVunP92PbU9m/YfoCxj3Na/b/pKfprk0fE6h1HCBGFl34rTy2m\n" +
                "17B/mscGpGJuwfNQkKoh6LC+oObSBmfWe2vovSq9bXWPabngf4Kiqs2e9/8An/8ABPVH62fWFnXM\n" +
                "6oYlZx+l4FYx+n45021iA61zfzX27Ge38yuutY99+Rk2erlXWZFn79r3Pd/nWFygkIm7JtRkKoB/\n" +
                "/9Pz5JJJXGspJJJJSkkkklKSSSSUpJJJJT//2f/tHXpQaG90b3Nob3AgMy4wADhCSU0EJQAAAAAA\n" +
                "EAAAAAAAAAAAAAAAAAAAAAA4QklNBDoAAAAAAO8AAAAQAAAAAQAAAAAAC3ByaW50T3V0cHV0AAAA\n" +
                "BQAAAABQc3RTYm9vbAEAAAAASW50ZWVudW0AAAAASW50ZQAAAABDbHJtAAAAD3ByaW50U2l4dGVl\n" +
                "bkJpdGJvb2wAAAAAC3ByaW50ZXJOYW1lVEVYVAAAAAEAAAAAAA9wcmludFByb29mU2V0dXBPYmpj\n" +
                "AAAAEQBBAGoAdQBzAHQAZQAgAGQAZQAgAHAAcgB1AGUAYgBhAAAAAAAKcHJvb2ZTZXR1cAAAAAEA\n" +
                "AAAAQmx0bmVudW0AAAAMYnVpbHRpblByb29mAAAACXByb29mQ01ZSwA4QklNBDsAAAAAAi0AAAAQ\n" +
                "AAAAAQAAAAAAEnByaW50T3V0cHV0T3B0aW9ucwAAABcAAAAAQ3B0bmJvb2wAAAAAAENsYnJib29s\n" +
                "AAAAAABSZ3NNYm9vbAAAAAAAQ3JuQ2Jvb2wAAAAAAENudENib29sAAAAAABMYmxzYm9vbAAAAAAA\n" +
                "Tmd0dmJvb2wAAAAAAEVtbERib29sAAAAAABJbnRyYm9vbAAAAAAAQmNrZ09iamMAAAABAAAAAAAA\n" +
                "UkdCQwAAAAMAAAAAUmQgIGRvdWJAb+AAAAAAAAAAAABHcm4gZG91YkBv4AAAAAAAAAAAAEJsICBk\n" +
                "b3ViQG/gAAAAAAAAAAAAQnJkVFVudEYjUmx0AAAAAAAAAAAAAAAAQmxkIFVudEYjUmx0AAAAAAAA\n" +
                "AAAAAAAAUnNsdFVudEYjUHhsQFIAAAAAAAAAAAAKdmVjdG9yRGF0YWJvb2wBAAAAAFBnUHNlbnVt\n" +
                "AAAAAFBnUHMAAAAAUGdQQwAAAABMZWZ0VW50RiNSbHQAAAAAAAAAAAAAAABUb3AgVW50RiNSbHQA\n" +
                "AAAAAAAAAAAAAABTY2wgVW50RiNQcmNAWQAAAAAAAAAAABBjcm9wV2hlblByaW50aW5nYm9vbAAA\n" +
                "AAAOY3JvcFJlY3RCb3R0b21sb25nAAAAAAAAAAxjcm9wUmVjdExlZnRsb25nAAAAAAAAAA1jcm9w\n" +
                "UmVjdFJpZ2h0bG9uZwAAAAAAAAALY3JvcFJlY3RUb3Bsb25nAAAAAAA4QklNA+0AAAAAABAASAAA\n" +
                "AAEAAgBIAAAAAQACOEJJTQQmAAAAAAAOAAAAAAAAAAAAAD+AAAA4QklNBA0AAAAAAAQAAAAeOEJJ\n" +
                "TQQZAAAAAAAEAAAAHjhCSU0D8wAAAAAACQAAAAAAAAAAAQA4QklNJxAAAAAAAAoAAQAAAAAAAAAC\n" +
                "OEJJTQP1AAAAAABIAC9mZgABAGxmZgAGAAAAAAABAC9mZgABAKGZmgAGAAAAAAABADIAAAABAFoA\n" +
                "AAAGAAAAAAABADUAAAABAC0AAAAGAAAAAAABOEJJTQP4AAAAAABwAAD/////////////////////\n" +
                "////////A+gAAAAA/////////////////////////////wPoAAAAAP//////////////////////\n" +
                "//////8D6AAAAAD/////////////////////////////A+gAADhCSU0ECAAAAAAAEAAAAAEAAAJA\n" +
                "AAACQAAAAAA4QklNBB4AAAAAAAQAAAAAOEJJTQQaAAAAAAM9AAAABgAAAAAAAAAAAAAAUAAAAFAA\n" +
                "AAAEAGkAYwBvAG4AAAABAAAAAAAAAAAAAAAAAAAAAAAAAAEAAAAAAAAAAAAAAFAAAABQAAAAAAAA\n" +
                "AAAAAAAAAAAAAAEAAAAAAAAAAAAAAAAAAAAAAAAAEAAAAAEAAAAAAABudWxsAAAAAgAAAAZib3Vu\n" +
                "ZHNPYmpjAAAAAQAAAAAAAFJjdDEAAAAEAAAAAFRvcCBsb25nAAAAAAAAAABMZWZ0bG9uZwAAAAAA\n" +
                "AAAAQnRvbWxvbmcAAABQAAAAAFJnaHRsb25nAAAAUAAAAAZzbGljZXNWbExzAAAAAU9iamMAAAAB\n" +
                "AAAAAAAFc2xpY2UAAAASAAAAB3NsaWNlSURsb25nAAAAAAAAAAdncm91cElEbG9uZwAAAAAAAAAG\n" +
                "b3JpZ2luZW51bQAAAAxFU2xpY2VPcmlnaW4AAAANYXV0b0dlbmVyYXRlZAAAAABUeXBlZW51bQAA\n" +
                "AApFU2xpY2VUeXBlAAAAAEltZyAAAAAGYm91bmRzT2JqYwAAAAEAAAAAAABSY3QxAAAABAAAAABU\n" +
                "b3AgbG9uZwAAAAAAAAAATGVmdGxvbmcAAAAAAAAAAEJ0b21sb25nAAAAUAAAAABSZ2h0bG9uZwAA\n" +
                "AFAAAAADdXJsVEVYVAAAAAEAAAAAAABudWxsVEVYVAAAAAEAAAAAAABNc2dlVEVYVAAAAAEAAAAA\n" +
                "AAZhbHRUYWdURVhUAAAAAQAAAAAADmNlbGxUZXh0SXNIVE1MYm9vbAEAAAAIY2VsbFRleHRURVhU\n" +
                "AAAAAQAAAAAACWhvcnpBbGlnbmVudW0AAAAPRVNsaWNlSG9yekFsaWduAAAAB2RlZmF1bHQAAAAJ\n" +
                "dmVydEFsaWduZW51bQAAAA9FU2xpY2VWZXJ0QWxpZ24AAAAHZGVmYXVsdAAAAAtiZ0NvbG9yVHlw\n" +
                "ZWVudW0AAAARRVNsaWNlQkdDb2xvclR5cGUAAAAATm9uZQAAAAl0b3BPdXRzZXRsb25nAAAAAAAA\n" +
                "AApsZWZ0T3V0c2V0bG9uZwAAAAAAAAAMYm90dG9tT3V0c2V0bG9uZwAAAAAAAAALcmlnaHRPdXRz\n" +
                "ZXRsb25nAAAAAAA4QklNBCgAAAAAAAwAAAACP/AAAAAAAAA4QklNBBEAAAAAAAEBADhCSU0EFAAA\n" +
                "AAAABAAAAAE4QklNBAwAAAAAFJcAAAABAAAAUAAAAFAAAADwAABLAAAAFHsAGAAB/9j/4gxYSUND\n" +
                "X1BST0ZJTEUAAQEAAAxITGlubwIQAABtbnRyUkdCIFhZWiAHzgACAAkABgAxAABhY3NwTVNGVAAA\n" +
                "AABJRUMgc1JHQgAAAAAAAAAAAAAAAQAA9tYAAQAAAADTLUhQICAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABFjcHJ0AAABUAAAADNkZXNjAAABhAAAAGx3dHB0\n" +
                "AAAB8AAAABRia3B0AAACBAAAABRyWFlaAAACGAAAABRnWFlaAAACLAAAABRiWFlaAAACQAAAABRk\n" +
                "bW5kAAACVAAAAHBkbWRkAAACxAAAAIh2dWVkAAADTAAAAIZ2aWV3AAAD1AAAACRsdW1pAAAD+AAA\n" +
                "ABRtZWFzAAAEDAAAACR0ZWNoAAAEMAAAAAxyVFJDAAAEPAAACAxnVFJDAAAEPAAACAxiVFJDAAAE\n" +
                "PAAACAx0ZXh0AAAAAENvcHlyaWdodCAoYykgMTk5OCBIZXdsZXR0LVBhY2thcmQgQ29tcGFueQAA\n" +
                "ZGVzYwAAAAAAAAASc1JHQiBJRUM2MTk2Ni0yLjEAAAAAAAAAAAAAABJzUkdCIElFQzYxOTY2LTIu\n" +
                "MQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAWFlaIAAA\n" +
                "AAAAAPNRAAEAAAABFsxYWVogAAAAAAAAAAAAAAAAAAAAAFhZWiAAAAAAAABvogAAOPUAAAOQWFla\n" +
                "IAAAAAAAAGKZAAC3hQAAGNpYWVogAAAAAAAAJKAAAA+EAAC2z2Rlc2MAAAAAAAAAFklFQyBodHRw\n" +
                "Oi8vd3d3LmllYy5jaAAAAAAAAAAAAAAAFklFQyBodHRwOi8vd3d3LmllYy5jaAAAAAAAAAAAAAAA\n" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABkZXNjAAAAAAAAAC5JRUMgNjE5NjYt\n" +
                "Mi4xIERlZmF1bHQgUkdCIGNvbG91ciBzcGFjZSAtIHNSR0IAAAAAAAAAAAAAAC5JRUMgNjE5NjYt\n" +
                "Mi4xIERlZmF1bHQgUkdCIGNvbG91ciBzcGFjZSAtIHNSR0IAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                "ZGVzYwAAAAAAAAAsUmVmZXJlbmNlIFZpZXdpbmcgQ29uZGl0aW9uIGluIElFQzYxOTY2LTIuMQAA\n" +
                "AAAAAAAAAAAALFJlZmVyZW5jZSBWaWV3aW5nIENvbmRpdGlvbiBpbiBJRUM2MTk2Ni0yLjEAAAAA\n" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAHZpZXcAAAAAABOk/gAUXy4AEM8UAAPtzAAEEwsAA1yeAAAA\n" +
                "AVhZWiAAAAAAAEwJVgBQAAAAVx/nbWVhcwAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAo8AAAAC\n" +
                "c2lnIAAAAABDUlQgY3VydgAAAAAAAAQAAAAABQAKAA8AFAAZAB4AIwAoAC0AMgA3ADsAQABFAEoA\n" +
                "TwBUAFkAXgBjAGgAbQByAHcAfACBAIYAiwCQAJUAmgCfAKQAqQCuALIAtwC8AMEAxgDLANAA1QDb\n" +
                "AOAA5QDrAPAA9gD7AQEBBwENARMBGQEfASUBKwEyATgBPgFFAUwBUgFZAWABZwFuAXUBfAGDAYsB\n" +
                "kgGaAaEBqQGxAbkBwQHJAdEB2QHhAekB8gH6AgMCDAIUAh0CJgIvAjgCQQJLAlQCXQJnAnECegKE\n" +
                "Ao4CmAKiAqwCtgLBAssC1QLgAusC9QMAAwsDFgMhAy0DOANDA08DWgNmA3IDfgOKA5YDogOuA7oD\n" +
                "xwPTA+AD7AP5BAYEEwQgBC0EOwRIBFUEYwRxBH4EjASaBKgEtgTEBNME4QTwBP4FDQUcBSsFOgVJ\n" +
                "BVgFZwV3BYYFlgWmBbUFxQXVBeUF9gYGBhYGJwY3BkgGWQZqBnsGjAadBq8GwAbRBuMG9QcHBxkH\n" +
                "Kwc9B08HYQd0B4YHmQesB78H0gflB/gICwgfCDIIRghaCG4IggiWCKoIvgjSCOcI+wkQCSUJOglP\n" +
                "CWQJeQmPCaQJugnPCeUJ+woRCicKPQpUCmoKgQqYCq4KxQrcCvMLCwsiCzkLUQtpC4ALmAuwC8gL\n" +
                "4Qv5DBIMKgxDDFwMdQyODKcMwAzZDPMNDQ0mDUANWg10DY4NqQ3DDd4N+A4TDi4OSQ5kDn8Omw62\n" +
                "DtIO7g8JDyUPQQ9eD3oPlg+zD88P7BAJECYQQxBhEH4QmxC5ENcQ9RETETERTxFtEYwRqhHJEegS\n" +
                "BxImEkUSZBKEEqMSwxLjEwMTIxNDE2MTgxOkE8UT5RQGFCcUSRRqFIsUrRTOFPAVEhU0FVYVeBWb\n" +
                "Fb0V4BYDFiYWSRZsFo8WshbWFvoXHRdBF2UXiReuF9IX9xgbGEAYZRiKGK8Y1Rj6GSAZRRlrGZEZ\n" +
                "txndGgQaKhpRGncanhrFGuwbFBs7G2MbihuyG9ocAhwqHFIcexyjHMwc9R0eHUcdcB2ZHcMd7B4W\n" +
                "HkAeah6UHr4e6R8THz4faR+UH78f6iAVIEEgbCCYIMQg8CEcIUghdSGhIc4h+yInIlUigiKvIt0j\n" +
                "CiM4I2YjlCPCI/AkHyRNJHwkqyTaJQklOCVoJZclxyX3JicmVyaHJrcm6CcYJ0kneierJ9woDSg/\n" +
                "KHEooijUKQYpOClrKZ0p0CoCKjUqaCqbKs8rAis2K2krnSvRLAUsOSxuLKIs1y0MLUEtdi2rLeEu\n" +
                "Fi5MLoIuty7uLyQvWi+RL8cv/jA1MGwwpDDbMRIxSjGCMbox8jIqMmMymzLUMw0zRjN/M7gz8TQr\n" +
                "NGU0njTYNRM1TTWHNcI1/TY3NnI2rjbpNyQ3YDecN9c4FDhQOIw4yDkFOUI5fzm8Ofk6Njp0OrI6\n" +
                "7zstO2s7qjvoPCc8ZTykPOM9Ij1hPaE94D4gPmA+oD7gPyE/YT+iP+JAI0BkQKZA50EpQWpBrEHu\n" +
                "QjBCckK1QvdDOkN9Q8BEA0RHRIpEzkUSRVVFmkXeRiJGZ0arRvBHNUd7R8BIBUhLSJFI10kdSWNJ\n" +
                "qUnwSjdKfUrESwxLU0uaS+JMKkxyTLpNAk1KTZNN3E4lTm5Ot08AT0lPk0/dUCdQcVC7UQZRUFGb\n" +
                "UeZSMVJ8UsdTE1NfU6pT9lRCVI9U21UoVXVVwlYPVlxWqVb3V0RXklfgWC9YfVjLWRpZaVm4Wgda\n" +
                "VlqmWvVbRVuVW+VcNVyGXNZdJ114XcleGl5sXr1fD19hX7NgBWBXYKpg/GFPYaJh9WJJYpxi8GND\n" +
                "Y5dj62RAZJRk6WU9ZZJl52Y9ZpJm6Gc9Z5Nn6Wg/aJZo7GlDaZpp8WpIap9q92tPa6dr/2xXbK9t\n" +
                "CG1gbbluEm5rbsRvHm94b9FwK3CGcOBxOnGVcfByS3KmcwFzXXO4dBR0cHTMdSh1hXXhdj52m3b4\n" +
                "d1Z3s3gReG54zHkqeYl553pGeqV7BHtje8J8IXyBfOF9QX2hfgF+Yn7CfyN/hH/lgEeAqIEKgWuB\n" +
                "zYIwgpKC9INXg7qEHYSAhOOFR4Wrhg6GcobXhzuHn4gEiGmIzokziZmJ/opkisqLMIuWi/yMY4zK\n" +
                "jTGNmI3/jmaOzo82j56QBpBukNaRP5GokhGSepLjk02TtpQglIqU9JVflcmWNJaflwqXdZfgmEyY\n" +
                "uJkkmZCZ/JpomtWbQpuvnByciZz3nWSd0p5Anq6fHZ+Ln/qgaaDYoUehtqImopajBqN2o+akVqTH\n" +
                "pTilqaYapoum/adup+CoUqjEqTepqaocqo+rAqt1q+msXKzQrUStuK4trqGvFq+LsACwdbDqsWCx\n" +
                "1rJLssKzOLOutCW0nLUTtYq2AbZ5tvC3aLfguFm40blKucK6O7q1uy67p7whvJu9Fb2Pvgq+hL7/\n" +
                "v3q/9cBwwOzBZ8Hjwl/C28NYw9TEUcTOxUvFyMZGxsPHQce/yD3IvMk6ybnKOMq3yzbLtsw1zLXN\n" +
                "Nc21zjbOts83z7jQOdC60TzRvtI/0sHTRNPG1EnUy9VO1dHWVdbY11zX4Nhk2OjZbNnx2nba+9uA\n" +
                "3AXcit0Q3ZbeHN6i3ynfr+A24L3hROHM4lPi2+Nj4+vkc+T85YTmDeaW5x/nqegy6LzpRunQ6lvq\n" +
                "5etw6/vshu0R7ZzuKO6070DvzPBY8OXxcvH/8ozzGfOn9DT0wvVQ9d72bfb794r4Gfio+Tj5x/pX\n" +
                "+uf7d/wH/Jj9Kf26/kv+3P9t////7QAMQWRvYmVfQ00AAv/uAA5BZG9iZQBkgAAAAAH/2wCEAAwI\n" +
                "CAgJCAwJCQwRCwoLERUPDAwPFRgTExUTExgRDAwMDAwMEQwMDAwMDAwMDAwMDAwMDAwMDAwMDAwM\n" +
                "DAwMDAwBDQsLDQ4NEA4OEBQODg4UFA4ODg4UEQwMDAwMEREMDAwMDAwRDAwMDAwMDAwMDAwMDAwM\n" +
                "DAwMDAwMDAwMDAwMDP/AABEIAFAAUAMBIgACEQEDEQH/3QAEAAX/xAE/AAABBQEBAQEBAQAAAAAA\n" +
                "AAADAAECBAUGBwgJCgsBAAEFAQEBAQEBAAAAAAAAAAEAAgMEBQYHCAkKCxAAAQQBAwIEAgUHBggF\n" +
                "AwwzAQACEQMEIRIxBUFRYRMicYEyBhSRobFCIyQVUsFiMzRygtFDByWSU/Dh8WNzNRaisoMmRJNU\n" +
                "ZEXCo3Q2F9JV4mXys4TD03Xj80YnlKSFtJXE1OT0pbXF1eX1VmZ2hpamtsbW5vY3R1dnd4eXp7fH\n" +
                "1+f3EQACAgECBAQDBAUGBwcGBTUBAAIRAyExEgRBUWFxIhMFMoGRFKGxQiPBUtHwMyRi4XKCkkNT\n" +
                "FWNzNPElBhaisoMHJjXC0kSTVKMXZEVVNnRl4vKzhMPTdePzRpSkhbSVxNTk9KW1xdXl9VZmdoaW\n" +
                "prbG1ub2JzdHV2d3h5ent8f/2gAMAwEAAhEDEQA/APPkkklcaykkkklKSSSSUpJJJJSkkkklP//Q\n" +
                "8+SSSVxrKTEgCToAnSSU7+H9Qvrdm41eXj9PPo3ND6y+ythLTq1/pvfv9yKf8XH1zDg04LA530Qc\n" +
                "imTHh+kR/q71r689YOP9W+l5766WNANwa3dTQ3TfZkx6uyv6FXu3/wCCVzrf1JqwW9c6iepZVt/R\n" +
                "hQ/HusMvdY9rLT6lv0/pPZ6fp7FGZEGiR9jIIxIsAvFX1WY91tFw2WUPdXa2eHMOx7Z/kuCHvZEz\n" +
                "p49ldwMzKZ1ajNbUM7LN4sFNrTZ61rj9Cxn0rHWvd/nruenfWP8AxidUzcnBxOlYTX4m37Ti3Vem\n" +
                "Kg/+aY/1Lmu97G/mpxkR2+1aIgvnQIIkajxTrqf8YmN03G6zjtxGUU5jsdruqUYpmlmRP5g02Od/\n" +
                "VZ7PTsXLIg2LQRRp/9Hz0kAEnQDkrqMP6l10YFfVPrRnjouJdrRQW78qzv7adfT/AMy2z/Semp/4\n" +
                "uulYmZ1i/qOe3fh9GpOU5kSDZ7vR3D/gvTst/wCM9NYPWOs5nXOo29TzHF1lx/RsnSuv/BUVfusY\n" +
                "3/Pf+kVokk0NK3LAAALOr0VWN/iqtf6Jy+p0E6DJsEMB/edtqf8A+e1V659TLMLMwaej5lfWKuqu\n" +
                "LcP0y0WSAHONoYXV+i1rvfkfmf4RZ2B9WfrD1LGGXgdPuyMZxIbazaGktO1+3e5m7a72r0H6tdD6\n" +
                "X9S+nHJ6rmYuD9YOo1O9N95BbSO1TGbmersdtdkua79JZ+jTJHh2lfhuuAvcUx6W7D+qfU+l/VPp\n" +
                "r23dVzrmW9ZywJhga+1uO2fob2t/Qt/wVH6X+cyET65ZQ/5qfWS50NN2ezHB8RX9kp/9FWKp9Uvq\n" +
                "50lv1qq6mz6x0dYzW+rdZSxo3vc9rmPuLhbZ9D1P3VsOt6JV9V7OrdZ9+IzqGRnV1A/ztoyLxiU7\n" +
                "P8Nu9n6P6H+k/RJh3B32+1d0rZx/8X/1ewujZGD1DrXs6v1Xe3peI4e6utrDbbe9v5l1lX/bTH+l\n" +
                "/OWrM6476v8ARus52T1ay7rHV8u11l2Di3Opx6WE/oaMrJZtttsZV6f6L/wJG+q3WMrqnVuu/XDq\n" +
                "DBbk9LwnOw8ckllQcLXsqZ/VZVsfZ/w11iq5uH9VfrfceqYHUquidUyIfmYOZpU6yPfdVdLPp/vM\n" +
                "/nf9FXYna8R4r8aRpWlIKPrH9RsofZupfVtmHS7Q5WI8usZP+E0bTa7b/Ws/qLP+tn1Y/YORRZjX\n" +
                "fbOl57PVwcrSS3R3pWbfbvax7Xts/wALWsfLxxi5d2M26vIFLywX0ndW+Pz6nfnMXXdZft/xW9Bq\n" +
                "yP59+S52NPIqacj/AKPpOrT64SK2OlLbsG+nV//Syv8AFx1fAwuqZXTupOFeH1in7ObCYaLBuDGv\n" +
                "f+Z6rLbGbv8ASbFU699Q/rB0TIexmLZm4TT+iyqGl8s/N9atk2VWfv8At2LnSAZB1B7LZ6b9cPrR\n" +
                "0uttOF1G1tLBDKrNtrWj91gvbZtVkg3Y67gsAIqi3vq70z6/5G3C6Q7NwcUuJL3ufRQwn6b/AHxu\n" +
                "/qUsQvrtiYeJ1GmlnVbutdQZXs6hfc4Pax4j06aX+7bzZvp3P9L+uqvUfrh9aOp1uqzOpXOqcIdV\n" +
                "XFTSPBwobXuWOAAIAgeCIBuzX0UZCqH4vffUbK+o/QrKurZHWHjqFmOa7saypwbW55Y+xrPTqfu2\n" +
                "ensa/wBT3rmvrLZgNyK8TpXVb+qdOZuta20Oayq2xznWNprcK2+7d+bWsdJIR1uyVGWlU9L9Quv4\n" +
                "PSOp34/VI/ZvVKvs2S48MOvpvs/4JzbLKrP66P1f/Fn13FsL+lMb1bpz/dj21PZv2H6AsY9zWv2/\n" +
                "6Sn6a5NHxOodRwgRhZd+K08tptewf5rHBqRibsHzUJCqIeiwvqDm0gZn1ntr6L0qvW11j2m54H+C\n" +
                "oqrNnvf/AJ//AAT1R+tn1hZ1zOqGJWcfpeBWMfp+OdNtYgOtc3819uxnt/MrrrWPffkZNnq5V1mR\n" +
                "Z+/a9z3f51hcoJCJuybUZCqAf//T8+SSSVxrKSSSSUpJJJJSkkkklKSSSSU//9kAOEJJTQQhAAAA\n" +
                "AABVAAAAAQEAAAAPAEEAZABvAGIAZQAgAFAAaABvAHQAbwBzAGgAbwBwAAAAEwBBAGQAbwBiAGUA\n" +
                "IABQAGgAbwB0AG8AcwBoAG8AcAAgAEMAUwA2AAAAAQA4QklNBAYAAAAAAAcACAEBAAEBAP/hDOVo\n" +
                "dHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVN\n" +
                "ME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0\n" +
                "YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8w\n" +
                "Ni0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9y\n" +
                "Zy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9\n" +
                "IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczpkYz0iaHR0\n" +
                "cDovL3B1cmwub3JnL2RjL2VsZW1lbnRzLzEuMS8iIHhtbG5zOnBob3Rvc2hvcD0iaHR0cDovL25z\n" +
                "LmFkb2JlLmNvbS9waG90b3Nob3AvMS4wLyIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5j\n" +
                "b20veGFwLzEuMC9tbS8iIHhtbG5zOnN0RXZ0PSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAv\n" +
                "c1R5cGUvUmVzb3VyY2VFdmVudCMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENT\n" +
                "NiAoV2luZG93cykiIHhtcDpDcmVhdGVEYXRlPSIyMDE4LTAzLTE5VDE0OjU1OjI5LTA3OjAwIiB4\n" +
                "bXA6TW9kaWZ5RGF0ZT0iMjAxOC0wMy0xOVQxNDo1NzoxNS0wNzowMCIgeG1wOk1ldGFkYXRhRGF0\n" +
                "ZT0iMjAxOC0wMy0xOVQxNDo1NzoxNS0wNzowMCIgZGM6Zm9ybWF0PSJpbWFnZS9qcGVnIiBwaG90\n" +
                "b3Nob3A6Q29sb3JNb2RlPSIzIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjc2MDhDQTYzQzAy\n" +
                "QkU4MTFBOUQyREU4RTlCQUJBOUY3IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjc2MDhDQTYz\n" +
                "QzAyQkU4MTFBOUQyREU4RTlCQUJBOUY3IiB4bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ9InhtcC5k\n" +
                "aWQ6NzYwOENBNjNDMDJCRTgxMUE5RDJERThFOUJBQkE5RjciPiA8eG1wTU06SGlzdG9yeT4gPHJk\n" +
                "ZjpTZXE+IDxyZGY6bGkgc3RFdnQ6YWN0aW9uPSJjcmVhdGVkIiBzdEV2dDppbnN0YW5jZUlEPSJ4\n" +
                "bXAuaWlkOjc2MDhDQTYzQzAyQkU4MTFBOUQyREU4RTlCQUJBOUY3IiBzdEV2dDp3aGVuPSIyMDE4\n" +
                "LTAzLTE5VDE0OjU1OjI5LTA3OjAwIiBzdEV2dDpzb2Z0d2FyZUFnZW50PSJBZG9iZSBQaG90b3No\n" +
                "b3AgQ1M2IChXaW5kb3dzKSIvPiA8L3JkZjpTZXE+IDwveG1wTU06SGlzdG9yeT4gPC9yZGY6RGVz\n" +
                "Y3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+ICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgPD94cGFja2V0IGVuZD0idyI/Pv/uACFBZG9i\n" +
                "ZQBkQAAAAAEDABADAgMGAAAAAAAAAAAAAAAA/9sAhAABAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB\n" +
                "AQEBAQEBAQEBAQEBAQEBAQEBAgICAgICAgICAgIDAwMDAwMDAwMDAQEBAQEBAQEBAQECAgECAgMD\n" +
                "AwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwP/wgARCABQAFAD\n" +
                "AREAAhEBAxEB/8QAzAAAAQQDAQEAAAAAAAAAAAAAAAEHCAkDBgoCBQEBAAIDAQEBAAAAAAAAAAAA\n" +
                "AAQGAgMFAQcIEAAABQQCAAUEAwEAAAAAAAACAwQFBgEHCAkAEhBAEUEKIDAyEyExFhURAAAHAAEB\n" +
                "AwcHDAMAAAAAAAECAwQFBgcIABESCdEyktITMxQhMUEicrKTEDBhQlJiI0NTc7MVURYXEgEAAgED\n" +
                "AwMDAQYFBQAAAAABEQIDIRIEADFBUSIFYRMUcSBAgTJCYhCRoVJy0iPTFQb/2gAMAwEBAhEDEQAA\n" +
                "AOPL9NfB0AAAAABBAAAAAAUQDGyt6rndcHTtpmsnC0zPH6GWGViogHl70DUe7yPhT+fK6Uzqs+fX\n" +
                "iriw8KhS41DD5ne/Trk60eTH+VC6KKbZty2R487sYPS8GC6EGG/Z48n4UmpnucpzdWzsR+a31kpM\n" +
                "Wyfm76Q7BzmEl4c5V6o3RVSbk1UmHHaRhveqVoO+LarxOzSHYeDJ6Psc+NM19jFPp8yrexV+yHh9\n" +
                "xCtzucTN7gCDuQ5+m7derb4iiAAAAAB6EAAAAAD/2gAIAQIAAQUA8wolbEmO/wBkwehRxZ5PYPp/\n" +
                "f1PjdHGviCQ1NCuSpqty5pjCFJDj1xyPla0pRXKDjlQ1c2LCglQTEy2qx9TMRYS3qVPCl0o1kO7s\n" +
                "kNYZA30jz4N1BMlp5KNobEzWiWyBpbzXZxVyJe8PSwLKYStNeHlpLbk6NQ/RsKU+qohqoVWaTRCq\n" +
                "PSssrbV5D04RYukTPUnJpMVJ3fkeSKQFy1qVL0rbM24ZTjKylFI40mNqatKVorjTItGkjTIiH/FP\n" +
                "oOb0CgRKZMmp5X//2gAIAQMAAQUA8uEIhiJjbmcV/l3T1NTHkqP0nUMGEQBfRStaVZ3B3ceKW8Zi\n" +
                "lvOUCXI1booPk5aUFeAAMwaONJySApI8YFdGyanpyyW8S/8AcchYWspuCvOb0PEb02L6PrOWi5GE\n" +
                "xFRPK9SrVo4+4LSUKMLajRthX/TTiTVbkLqBYJUmZngCwgCY5w/eGOxVQn7O0cXAPaEL7SsnLKLq\n" +
                "xiZkBL8pJ6xlaQUYvjKr96GMCJG/uRKswNRBETI3QkJskdDgDGMwXiBzXlgPXK1NPK//2gAIAQEA\n" +
                "AQUAEMffuPncfO4+dx87j53HzuPncfO4/UX5/Y9xfn4GmlEF2e0K7cr82zN+OPuXTrJvF3220uo9\n" +
                "tNSiTiVJXuL8/AYAGB14ZpbxM2VWauk+M4+Ntirv3PYMs8eNjHyHcsL1fIhtrjfa/MX3VKCEhVnt\n" +
                "L8ct7YqKW6+KnMXTN7THILF3exgWWe06ZL7kbmp66ptAOvqyeD89ziX6/cHcyoRsb0a3ZK2v6yRa\n" +
                "7bh/HYxWtRevMDMPMa8Gf2Rdh9ZmwvKG22tfCHFzRbjrqU1zYntu09xk+FEU1e6tMwrm5b5Y3rs5\n" +
                "qx3RTG7MBT2purmQ9Abfi4/HKy5sVYjKHO/Q5sCwNnmu7GXf1cwe7K09n7P5DaObmaPNfT/spkVh\n" +
                "UFwNDOetkcLsmstvjP51WofLJ6Db0QpNtg2Es+fd9Dyijw45bgNnuJscyG2/7QMqWNOnISE+Nqch\n" +
                "MiLDJ53PLg3VkPuL8/se4gi79Rc6i51FzqLnUXOoudRc6i51F6//2gAIAQICBj8A/eMmDLzT7tFE\n" +
                "K3YRhJKo/wAHqycxg7+zJ/0dY+RjtOK9Cw9pqkzD9Nep3Efr0J2/azfK8vgl89mdsu1t/wAVarby\n" +
                "QzraILWPhOLX4zB9vkmXfTWIrawAagaMiImnbrJxr53Bxq0TdWxTYA9nsAeO3+XWLmPyue2TILjS\n" +
                "677VNfdWlohgXax6Lp1ntntkvw/uW+1bJ/O10iddTvqSSIMAf4K9usnA+C4LyORVhtIUH/l2Z1Ik\n" +
                "01LTIfkPF4twF2+80O/e1TT9dfE9uuVb5Ph5OPyMEFpHasWdXb7X2uiehXdaxV53z3Owv4GOlq4i\n" +
                "doLpvDXdFoE7Os2dgW/+crlvGLHxLXZ7G/7rr+u6v8euZx+Dd/8AWcePuWnS1mwFT/dDr6aSaDa3\n" +
                "x+PhFeNw8BFcjWbWYBt9udqJq7pmy3pHat+T8d825Mk2s1tQBWW3ZtrZ00JV7ncz4eVi+38hhttv\n" +
                "XtDrrDrEiRqkQ9t1uNwONpn5OQoP08wz3lDswMkWB6w4MFCQ1YhZiZ1WWDdrEmkVKhfj8nl1M9SW\n" +
                "p3NJDxD9GO54ek4nEy5fjMdgShDcGe8MTLCi67kNK1v8S/BX4uC9a6tvFbUZjZWexXTQkNCDrH8b\n" +
                "w6H3fxsONUnabMdm5/tS38qe6YK+5Ovg/gcF4x8rkBe8e591BE1GVpb9ahJWKn4fJ+OvyeIaVtjN\n" +
                "1gIItU1dpFZnaGg2A6x5nBfG2qO25FjSYSWI7Po9fL34YfimCpIaSmPQ9F22/wAnric/im7Lxb7g\n" +
                "9DSX6u4rp6DrKDSvIz0w8g022Y0AjV/mXXtMxKV3bS3K5WPj5+UkQFbWY9fPaYmDQGxo9chv8dTj\n" +
                "cQvOMrXbaxbVbABobYQJIk7Ll4FfjK/h0y7qWL0mwSDrY7zKJokfVzcn5D47Hh5lrus1tZr41JYJ\n" +
                "ak2UAO0dYOVwp/L41t9T/V2/3SD3/pCNdDB8jPH5VCEsWiTuSygf3u6dHtK8L4LHbkcu5E1LASMy\n" +
                "6QDHuHtMNWLGXNyrNvkM9t2S0uq6w9uyvfUVdNzURJOrZORwK73WazVX1WqL/Feq5MHApvPNpsj6\n" +
                "jZUTxEdQGn7BbkcLFksAG6paI9JGOtvHwUx1mYqAHjQO38P3b//aAAgBAwIGPwD93rSlVusAaqvY\n" +
                "Pr1jy1wrSwJG3sg/1Xq/TtHkUh6Bw21+uP8A8vTxb438gtG3uy6gR3WfHX2XFb70xth3T6R3/wBO\n" +
                "rUvVLjCOiP1P2RGE6xcel0xUks6A6aBtK2rtkspeKkBX3Upb5PI829L1cVSxpG8JkELPukbSjCIg\n" +
                "9fdrgM2S1hsWq3031VBZWYqSyztJU6y8a3x9TFSyNtoVidIpfbaE/uXz26wla0rywqJX+UUs5A/R\n" +
                "aMMRumJtb/CmPHVb2YA8vX5PymYK7dyEwV89otpo7pKmptSLJxTkRMVE/HbKsAbC12X6T5k79YTg\n" +
                "cirS72NQJD26rOug2dzKtK1Y43x/FyVrlk3eVrVrNDT+/da2ittK+5KfLPFpPItyQI7v29jH6+xj\n" +
                "rE5TdycmshpoOs+K+KTrZm3krjz351jLmvuNqustrQJVSFalq1qAVre7ap0cTk8MpX21qN7Mx2rC\n" +
                "bIPS9oe0Mx1j5PEtu41wf4ae49CULDoNq7dLbaZ+bmRrirZfUKgonpae+mlLVZrax1mx5rQUukHb\n" +
                "dWRfEgyUkIr43Wu2pmxla0t23b9TwzWtiGfX9Tx1XFbkv5O3RtLtkgUljtBWYA2iu+1jn25hfKW9\n" +
                "oFiDbc2y2Zmd697WG3ez08zMxT8jLkCYl35CGdNu2d06FRbe0evlPkH3PGpawJo+12WJ1rH/AHK7\n" +
                "ZIraWb7rNOS8mmO86s7CXdZruRCVb7bV+4TLAx1fGZqXprrVkCWJYJkC0xCI+Y6wV5svIMmRtrr/\n" +
                "ADXrL6hltR8/0vjrk8HMB96qPrYgAPQqbp7rvGNtbJl5GE+4XtKBHussx4K+fdYgds2jcmC9rU44\n" +
                "/wC+/aO1Wlvt+A1VJnbbt1xw5jkyszVVCPapK2dRJtZhkq/zFaZsWazltU3OzIyn6bqySntDu6Gp\n" +
                "1i4vE5lrYq1BrttWfKpZg1K2gqFrLZ1rPWXhcgr9vKJ9bbgE+sRpXyWuzIFjlcDNLdlZ9TW011Nz\n" +
                "/TWqGsJWAryPkcpUrbQ7i9x9bPf2NCUJ3VmtsfG4ofjYiDyaEBV109UYsx3KVvat62S4yIwieRNR\n" +
                "6rWubt5g7egI0qH9tD6zr1als3nvBMeiEUsf8qPf6HTfJdtd7qqvju69tP2NlOVcJVRiyvlsRa3f\n" +
                "zZ6DPnbEQ+FJH3JDbUH3Trr+7f/aAAgBAQEGPwBT+Ip71X+Yf+ob97r3in4h/W694p+If1uveKfi\n" +
                "H9br3in4h/W694p+If1uveKfiH9br3in4h/W694p+If1ug/iKecX+Yf9oP3ulP7qv+Q35kPtF+8H\n" +
                "Sn91X/Ib8qiyyhEUUSHVVVUMBE0kkyidRRQw/IUhCAIiP0AHVO2DN+IjlWgaDBx9npr+465jtBmp\n" +
                "qtzDRCQhp7/qtourGwxsdNR7lNw1+LQQVUQOU4kKAh1HxznitTGshLC5LFsHXJ7jm3eyIs0hcPPg\n" +
                "Wa2ildO/hG5RUU9mQwkTDvD8ny9XeiXhkSv2vNrbaKJeIxd4zcJQNrpc6+rNni1ZFqstHOSxc5Gr\n" +
                "oe3SUOgr3O8QwlEBEVwftxbB8ougMItAD5+8LsA+GAvZ9Pe7Ok126qS6Cpe+ksioRVFUvaId5NQg\n" +
                "mIcvaHzgIh0H2i/eDpT+6r/kN+UyahCKJnKJDpqFA5DkMAgYhyGASmIYo9ggPyCHWO+F3xN5ZXGn\n" +
                "USBrrGPeaFHVSsJ2/CMArLprHO7Fa9qTh1NARrNQZOUYqAbovmso+cmZxbd0BQKKXilcnHfNjlNe\n" +
                "NG8OhlxwueM6LebA3mb9ZtFv9Pqd7fo2u9ictoj5BnNWKORh3kI5jVY8FyKLg7EggfKdzi6RHcmt\n" +
                "wX3KOurDOtLrr7S0OQesW6Xe9+BtlaZlPL3Ocvdgm1FxBABdGkTFcF+sn29bRgOMcCOEsPP4KvUS\n" +
                "7hhOp4slmEHj8XoST93Sa5anNz2OJmJItngYpy4alYpOlnLBIy5CgQxBHIIrHavhud71NccazOc7\n" +
                "8s40SIPMVoXJVR4kgs2gGBWscnXpmTYFeAu2MyjXjuNax7560TdOlFVw+0X7wdOnTpYiDZuK6qyy\n" +
                "giBEyFUN2iPYAmMIj8gFABMYwgAAIiAdVHln4s/K6H8OLDtAJ8TluTuKstdOXWtNwbpvUzRuaC2k\n" +
                "HFN+PYuE1E2wxc5KtiqEM/asAUJ3kqO65AeJ7lzt6AxyGzaDFna0xi/UL7FvMyrSMzCxIx8YZwIH\n" +
                "OLmHQbpk96ZIoCYOK1J4T8j808QWoc5JuTgeNYZ9MVhppppCIZR0tMPr3HV6Xl6iOaQMLJg7f3Bo\n" +
                "u1ZRjdq4NINGYFTMpwS8HLi5ZIDQeavJ3aqBp/iYchm0I2ljMqTC0e2XeMx6HK9KVxWkbDGRR0K8\n" +
                "xOILwNVMvJKtwfz6boPGxvEgDKOW0XxAc5w1s8E/eM/hMqNxIzz2ahikE4qoL0SVMYod7upgYPn7\n" +
                "euKvJDnV8PAc5ecil6guBfHaxRoq2vKs0r+czN7vmrWeKcgBazoVrozAU11F+4rARkk0iwMMjKPW\n" +
                "zflVqHMO3bV4gvOffdbud70Tinxp3S44Lxfwihzk++VzXK912quPou9aDaq3RWsMUYEhFm7IEToq\n" +
                "RibYUnTxHMuU3gm1Pjvn8sBo1feOMGkvLDo2dEddiCVvcpMYDO71MqRChiuXS6D2VcmSSOYWTz3J\n" +
                "8ns2X6aTkBwz5T1Q+i8VN7RUjXLycgCs4iZdUe5uoZNvEP7PEwFgYP2Ms0Rbs7BFOPiCJIOEHjdH\n" +
                "WOTXIOHCw4Z4d2NyXJqbrq8cjKxs/pDZabcZ4eVYLnTTeo0mOqU1YWrcREi0tHsRUAUyGKa+8rdw\n" +
                "nX0vadCermqMAs9WcweVZeDty6pOVUdkfutoauVmJdFBx7EhVJKTUcvnRlnLhRQWGy8duH+w65lE\n" +
                "rITUZDX+sI1NnBTb+tyLqGsCUENltMC+mE4ebYOGSyzdE6APG6qJTidM4Fe6ny85JcWeMvie8usx\n" +
                "syNLntvmK/KV3BoQrdo6Y0CtV9vYa+8vTeszjxg/uz5g9ZtZuYImwQdi0bNnK+f8rq/41GG+IJv8\n" +
                "WvuGsWzO6xTYhHQNFtF8pM7VbHob6bZa1bDx5K86uPxQlKyUTTSKk2TFJMpe7beZPOA55/FIHxFO\n" +
                "VHNWo59GvinPsmrRXLXdWHH/ADdGuqGKTQ1p580jXbSGUOEaqq0RcSBgjGrzrxYPGy5HQERetY4S\n" +
                "8J7DPccMhev3rqhZA0novULHXaDVnKCZXTCPiK5n7iNkJVBArh8vY5iQMT2zkAK+5Y8eua2W+Gzz\n" +
                "K1hu0svJDily3K3hMnsWn/6xAlq0PP8ARFZKsRzhaxLNxVXfRSsgSbFMHbuMjn6zkFNFy9joVA1x\n" +
                "tnlxl6i31PJpVxO5hoQRCxURtFAmnLdsvK1t4qIkSWEnYZRM4EMcgFUN4TlT0sSK6TZeT1hnsUI+\n" +
                "KQ000x+BkeRrgzhFU4g4TiSUmdim5A7BD4Z0zIPZ9TrfOMnKCdZ1PC/EDxwuDvbbKP28NBQ+hsnN\n" +
                "mYVqFsdhcqop1yMv9Yvk1FNnxjeySl/gk1O6Vf2hLJBw+G6RyRwCJcrmoG9YfUZPQW0hTCLgjC/+\n" +
                "j0mrISNwz+4MGSqDeRTVZKxirsDnZu10RAQgcO4XTnOTjBjTmyP3khZrVZNP478daA9lnCTmz2V0\n" +
                "nYmUdISjtRdYHTmOrse+fPlzGMVIDnUVDN6ZAc/9i8R7lBXc1c1nl7q2p2GPuFXotwhHcarS87zS\n" +
                "ztXUoaEbJqSE0tK1gXsoaCUBuZy7M9cuEUs/5kaV4j1uQ5QW3j7KZ9puIXXFbrE1DK7RdZaoT1wi\n" +
                "oBepZjZZCYJXX9S/17GSGbcoSjJQXYpomVKgjS8f4fc99z5t8U6yjbNNhYvTYy01OgY1r+lW2wTd\n" +
                "1icyqUtE1OCcJTKMud2u7ZQzUGSjpVAFVRWV7NWzblgDVHiPzcyU3H/aZ6RI4NCUh+K0wjUbPbjN\n" +
                "AO6QoMpG2yag5lwQCgwJKN3ihyN2yw9Opvh9Xaxzx4qz6v8At8i0DNr1noXwKO/MqtW4+41awTUD\n" +
                "CWKUjGBComma67fR8kQqbgEmp1Tt0mW3eK7d6D4cfCyrrJvtBm79o1NlNwvkQyUROvnuV0mnSFqR\n" +
                "j7NaG5TNEnCqjuSbFV9ozinywJpDRG2P0l1kXDbi3QGWG8O8ZcIfALVrPIwkWyk7xOxBXDpKHtN8\n" +
                "Qr8aiDIqhzRsNFMGqp1XJXKyrhBdJNZFYy6aqKxCqpKpmUMBiKJnAxDkMHzgICHUVS8N5oatFUWB\n" +
                "aJR9fomgJ1nZalX41ATihGQDDVoK2vYSNRE49xu1cooJl+qUgFAACTqm181tfkaZNtVGE5SM+Uru\n" +
                "MVSbj1jFOtHzTDJoOoPJhgqYgd9F05VSOUO6YolEQFNs1RSbt0gEE0UUypJE7xhObukIAFATnMJj\n" +
                "D85jCIj8oj+UQ+gQEBD6BAQ7BAf+QEOlmeE8ht5xNg4ModeKyfYNAoMKoZbs9qYYKtz7CGKdXs+s\n" +
                "YG4GEfp6LbtX0TQtXtaYGBKzahebToU63A5jGODSTt0tLumRTmMPaCJkyj2/N0H2i/eDpT+6r/kN\n" +
                "+ZD7RfvB0p9Q/vVf1Df1Dfo68w/oG8nXmH9A3k68w/oG8nXmH9A3k68w/oG8nXmH9A3k68w/oG8n\n" +
                "XmH9A3k6D6h/OL+ob9oP0df/2Q==\n";
        if(images.length==0){
            imageBytes = Base64.decode(ss, Base64.DEFAULT);
        }else {
            imageBytes = Base64.decode(images[position], Base64.DEFAULT);
        }

        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        //image.setImageBitmap(decodedImage);

        viewHolder.icon.setImageBitmap(decodedImage);

        return convertView;
    }

    private static class ViewHolder {

        TextView txtName;
        TextView txtVersion;
        ImageView icon;

    }

}