package org.uberfire.ext.plugin.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class ScreenEditor {

    public static final String PLACE_NAME_KEY = "Place Name";

    private SCREEN_TYPE type = SCREEN_TYPE.DEFAULT;

    private String externalComponentFQCN;

    private List<ScreenParameter> parameters = new ArrayList<ScreenParameter>();

    private String placeName;

    public ScreenEditor() {

    }

    public ScreenEditor( String screenName,
                         List<ScreenParameter> parameters ) {
        this.placeName = screenName;
        this.parameters = parameters;
    }

    public List<ScreenParameter> getParameters() {
        return parameters;
    }

    public HashMap<String, String> toParametersMap() {

        HashMap<String, String> parametersMap = new HashMap<String, String>();
        for ( ScreenParameter parameter : parameters ) {
            parametersMap.put( parameter.getKey(), parameter.getValue() );
        }
        return parametersMap;
    }

    public void addParameters( ScreenParameter param ) {
        if ( param.getKey().equalsIgnoreCase( PLACE_NAME_KEY ) ) {
            this.placeName = param.getValue();
        }
        parameters.add( param );
    }

    public void removeParameter( final String parameterName ) {
        final Iterator<ScreenParameter> itr = parameters.iterator();
        while ( itr.hasNext() ) {
            final ScreenParameter sp = itr.next();
            if ( sp.getKey().equals( parameterName ) ) {
                itr.remove();
                if ( sp.getKey().equalsIgnoreCase( PLACE_NAME_KEY ) ) {
                    this.placeName = null;
                }
            }
        }
    }

    public void setParameterValue( final String parameterName,
                                   final String parameterValue ) {
        for ( ScreenParameter sp : parameters ) {
            if ( sp.getKey().equals( parameterName ) ) {
                sp.setValue( parameterValue );
            }
            if ( parameterName.equalsIgnoreCase( PLACE_NAME_KEY ) ) {
                this.placeName = parameterValue;
            }
        }
    }

    public void setParameters( List<ScreenParameter> parameters ) {
        for ( ScreenParameter param : parameters ) {
            if ( param.getKey().equalsIgnoreCase( PLACE_NAME_KEY ) ) {
                this.placeName = param.getValue();
            }
        }
        this.parameters = parameters;
    }

    public void setPlaceName( String placeName ) {
        this.placeName = placeName;
    }

    public String getPlaceName() {
        if ( this.placeName == null || this.placeName.isEmpty() ) {
            for ( ScreenParameter parameter : parameters ) {
                if ( parameter.getKey().equalsIgnoreCase( PLACE_NAME_KEY ) ) {
                    this.placeName = parameter.getValue();
                }
            }
        }
        return placeName;
    }

    public void setType( SCREEN_TYPE type ) {
        this.type = type;
    }

    public boolean isAExternalComponent() {
        return type == SCREEN_TYPE.EXTERNAL;
    }

    public enum SCREEN_TYPE {
        DEFAULT, EXTERNAL
    }

    public String getExternalComponentFQCN() {
        return externalComponentFQCN;
    }

    public void setExternalComponentFQCN( String externalComponentFQCN ) {
        this.externalComponentFQCN = externalComponentFQCN;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( !( o instanceof ScreenEditor ) ) {
            return false;
        }

        ScreenEditor that = (ScreenEditor) o;

        if ( externalComponentFQCN != null ? !externalComponentFQCN.equals( that.externalComponentFQCN ) : that.externalComponentFQCN != null ) {
            return false;
        }
        if ( parameters != null ? !parameters.equals( that.parameters ) : that.parameters != null ) {
            return false;
        }
        if ( placeName != null ? !placeName.equals( that.placeName ) : that.placeName != null ) {
            return false;
        }
        if ( type != that.type ) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + ( externalComponentFQCN != null ? externalComponentFQCN.hashCode() : 0 );
        result = 31 * result + ( placeName != null ? placeName.hashCode() : 0 );
        result = 31 * result + ( parameters != null ? parameters.hashCode() : 0 );
        return result;
    }
}
