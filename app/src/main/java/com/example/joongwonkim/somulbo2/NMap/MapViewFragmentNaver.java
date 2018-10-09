//package com.example.joongwonkim.somulbo2.NMap;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.joongwonkim.somulbo2.R;
//import com.nhn.android.maps.NMapController;
//import com.nhn.android.maps.NMapView;
//import com.nhn.android.maps.maplib.NGeoPoint;
//import com.nhn.android.maps.nmapmodel.NMapError;
//import com.nhn.android.maps.overlay.NMapPOIdata;
//import com.nhn.android.maps.overlay.NMapPOIitem;
//import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
//import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;
//
//public class MapViewFragmentNaver extends NMapFragment
//        implements NMapView.OnMapStateChangeListener, NMapPOIdataOverlay.OnStateChangeListener{
//
//    NMapView mapView;
//    NMapController mapController;
//    NMapViewerResourceProvider mapViewerResourceProvider;
//    NMapOverlayManager mapOverlayManager;
//
//    NMapViewerResourceProvider mMapViewerResourceProvider;
//    private NMapOverlayManager mOverlayManager;
//
//
//    @Override
//    public void onMapInitHandler(NMapView nMapView, NMapError nMapError) {
//        if (nMapError == null) {
//            moveMapCenter();
//        } else {
//            Log.e("map init error", nMapError.message);
//        }
//
//
//    }
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
////        View v = inflater.inflate(R.layout.fragment_map_view, container, false);
////        mapView = (NMapView) v.findViewById(R.id.map_view);
//        mapView.setClientId(getResources().getString(R.string.n_key));
//        mapView.setClickable(true);
////        return v;
//    }
//
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        mapView.setBuiltInZoomControls(true, null);
//        mapView.setOnMapStateChangeListener(this);
//        mapController = mapView.getMapController();
//        mapViewerResourceProvider = new NMapViewerResourceProvider(getActivity());
//        mapOverlayManager = new NMapOverlayManager(getActivity(), mapView, mapViewerResourceProvider);
////        moveMapCenter();
//
//        mMapViewerResourceProvider = new NMapViewerResourceProvider(getContext());
//
//// create overlay manager
//        mOverlayManager = new NMapOverlayManager(getContext(), mapView, mMapViewerResourceProvider);
//
//        int markerId = NMapPOIflagType.PIN;
//
//// set POI data
//        NMapPOIdata poiData = new NMapPOIdata(2, mMapViewerResourceProvider);
//        poiData.beginPOIdata(2);
//        poiData.addPOIitem(127.0630205, 37.5091300, "Pizza 777-111", markerId, 0);
//        poiData.addPOIitem(127.061, 37.51, "Pizza 123-456", markerId, 0);
//        poiData.endPOIdata();
//
//// create POI data overlay
//        NMapPOIdataOverlay poiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);
//
//
//
//        poiDataOverlay.showAllPOIdata(0);
//
////
////        NGeoPoint currentPoint = new NGeoPoint(35.235826, 128.580946);
////        mapController.setMapCenter(currentPoint);
////
////        NMapPOIdata poiData = new NMapPOIdata(2, mapViewerResourceProvider);
////        poiData.beginPOIdata(2);
////        poiData.addPOIitem(127.0630205, 37.5091300, "현재 위치", markerId, 0);
////        poiData.addPOIitem(127.061, 37.51, "도착 위치", markerId, 0);
////        poiData.endPOIdata();
////
////        NMapPOIdataOverlay poiDataOverlay = mapOverlayManager.createPOIdataOverlay(poiData, null);
////        poiDataOverlay.showAllPOIdata(0);
////        poiDataOverlay.setOnStateChangeListener(this);
//
//
//    }
//
//
//
//
//    private void moveMapCenter() {
//        NGeoPoint currentPoint = new NGeoPoint(35.235826, 128.580946);
//        mapController.setMapCenter(currentPoint);
//
//        NMapPOIdata poiData = new NMapPOIdata(2, mapViewerResourceProvider);
//        poiData.addPOIitem(35.237542, 128.582417, "현재 위치", NMapPOIflagType.FROM, 0);
//        poiData.addPOIitem(35.235826, 128.580946, "도착 위치", NMapPOIflagType.TO, 0);
//        poiData.endPOIdata();
//
//        NMapPOIdataOverlay poiDataOverlay = mapOverlayManager.createPOIdataOverlay(poiData, null);
//        poiDataOverlay.showAllPOIdata(0);
//        poiDataOverlay.setOnStateChangeListener(this);
//
//    }
//
//    @Override
//    public void onMapCenterChange(NMapView nMapView, NGeoPoint nGeoPoint) {
//
//    }
//
//    @Override
//    public void onMapCenterChangeFine(NMapView nMapView) {
//
//    }
//
//    @Override
//    public void onZoomLevelChange(NMapView nMapView, int i) {
//
//    }
//
//    @Override
//    public void onAnimationStateChange(NMapView nMapView, int i, int i1) {
//
//    }
//
//    @Override
//    public void onFocusChanged(NMapPOIdataOverlay nMapPOIdataOverlay, NMapPOIitem nMapPOIitem) {
//
//    }
//
//    @Override
//    public void onCalloutClick(NMapPOIdataOverlay nMapPOIdataOverlay, NMapPOIitem nMapPOIitem) {
//
//    }
//}
