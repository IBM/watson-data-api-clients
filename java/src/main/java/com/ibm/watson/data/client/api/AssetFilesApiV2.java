/*
 * Copyright 2020 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.data.client.api;

import com.ibm.watson.data.client.ApiClient;
import com.ibm.watson.data.client.model.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;
import reactor.core.publisher.Mono;

/**
 * API endpoints for dealing with files assets.
 */
public class AssetFilesApiV2 {

    private ApiClient apiClient;
    public static final String BASE_API = "/v2/asset_files";

    @Autowired
    public AssetFilesApiV2(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() { return apiClient; }

    public void setApiClient(ApiClient apiClient) { this.apiClient = apiClient; }

    /**
     * Copy asset file.
     * Copies a file between source and target provided in the POST body. Any
     * combination of spaces, projects and catalogs are allowed. Viewer permission
     * is required for the source and editor permission is required for the
     * target. Catalog source or target requires service auth. Service auth is
     * supported for projects as well.
     * @param copyAssetFile Information on the asset to copy.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> copy(CopyAssetFile copyAssetFile) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/copy", HttpMethod.POST, pathParams, queryParams,
                copyAssetFile, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Create project, catalog, space or account root folder.
     * Before files can be uploaded, project/catalog/account/space root folder
     * needs to be created. If the folder already exists the call will fail.
     * Project folder can be created with additional content required for internal
     * Git. Requires Bearer auth with admin permission for project or space.
     * Creating folder for a catalog requires service Basic auth.
     * @param catalogId The catalog to create the folder for. One of catalog,
     *     project, space or account id is required.
     * @param accountId The catalog id the file is associated with. One of
     *     catalog, project, space or account id is required.
     * @param projectId The project to create the folder for. One of catalog,
     *     project, space or account id is required.
     * @param spaceId The space to create the folder for. One of catalog, project,
     *     space or account id is required.
     * @param initializeGit Optional param for project containers.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> createFolder(String catalogId,
                                   String accountId,
                                   String projectId,
                                   String spaceId,
                                   Boolean initializeGit) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_id", accountId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "initialize_git", initializeGit));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.PUT, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Create archive for target.
     * Generate an archive and save it to the path provided. Only supports service
     * auth.
     * @param path The filename where the project archive will be saved.
     * @param projectId The project id the file should be associated with.
     * @param spaceId The space id the file should be associated with.
     * @param isDirectory If true only one element can be supplied in body and it
     *     must be directory. The entire directory content will be zipped into the
     *     archive. Default is false.
     * @param notify On completion of the archinving a rabbit MQ task will be sent
     *     out. Default is true.
     * @param hideLog In true, the deflate log will be a hidden file. Default is
     *     false.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> deflate(@NonNull String path,
                              String projectId,
                              String spaceId,
                              Boolean isDirectory,
                              Boolean notify,
                              Boolean hideLog) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("path", path);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "is_directory", isDirectory));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "notify", notify));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "hide_log", hideLog));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(BASE_API + "/{path}/deflate",
                HttpMethod.POST, pathParams, queryParams,
                null, headerParams, cookieParams, formParams,
                localVarAccept, localVarContentType,
                localVarReturnType);

    }

    /**
     * Delete single asset file/folder.
     * Deletes a file in a project, space or a catalog. Requires minimum editor
     * permission for projects and spaces (service or user). Catalogs supports
     * only service auth. Account requires users to have account admin privelege
     * but also accepts service auth. Please note the 'assets' dir and its
     * subdir 'data_asset' cannot be deleted.
     * @param path Asset file path
     * @param catalogId The catalog id the file should be associated with. One of
     *     catalog, project, space or account id is required.
     * @param accountId The catalog id the file is associated with. One of
     *     catalog, project, space or account id is required.
     * @param projectId The project id the file should be associated with. One of
     *     catalog, project, space or account id is required.
     * @param spaceId The space id the file should be associated with. One of
     *     catalog, project, space or account id is required.
     * @param root If true is supplied in request URL the
     *     api will return relative to target container's root directory
     *     instead of assets directory. Supported for services. Also supported for
     *     account admin if targeting account directory.
     * @return Void
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<Void> delete(@NonNull String path,
                             String catalogId,
                             String accountId,
                             String projectId,
                             String spaceId,
                             Boolean root) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("path", path);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_id", accountId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "root", root));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(
                BASE_API + "/{path}", HttpMethod.DELETE, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Batch delete or delete project/catalog/account/space folder.
     * Delete either files in batch or a project/catalog/account/space folder. If
     * request body is present it should be a list of filenames/filepaths to be
     * deleted in the provided project, catalog, space or account. Files are
     * deleted asyncronously so some files may be deleted and others skipped. If
     * there is no request body the project/catalog/account/space folder will be
     * deleted but will fail if the project/catalog/account/space folder is not
     * empty. For projects and spaces batch delete requires editor permission. For
     * account batch delete user must be account admin. Deletion of the
     * project/catalog/account/space folder requires admin (account admin for
     * accounts). Service auth is accepted for deletion of assets but not for root
     * folder deletion. For catalogs only service auth is supported and it will
     * work for either deletion method. Please note the 'assets' dir and
     * its subdir 'data_asset' cannot be deleted.
     * @param catalogId The catalog folder to run the delete operation on. One of
     *     catalog, project, space or account id is required.
     * @param accountId The catalog id the file is associated with. One of
     *     catalog, project, space or account id is required.
     * @param projectId The project folder to run the delete operation on. One of
     *     catalog, project, space or account id is required.
     * @param spaceId The space folder to run the delete operation on. One of
     *     catalog, project, space or account id is required.
     * @param root If true is supplied in request URL the
     *     api will return relative to target container's root directory
     *     instead of assets directory. Supported for services. Also supported for
     *     account admin if targeting account directory.
     * @param forceDelete If true all safeguards
     *     regarding non-empty directory will be bypassed. Only works for
     *     projects.
     * @param requestBody Asset files to delete
     * @return FileDeleteResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<FileDeleteResponse> delete(String catalogId,
                                           String accountId,
                                           String projectId,
                                           String spaceId,
                                           Boolean root,
                                           Boolean forceDelete,
                                           List<String> requestBody) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_id", accountId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "root", root));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "force_delete", forceDelete));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"application/json"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<FileDeleteResponse> localVarReturnType = new ParameterizedTypeReference<FileDeleteResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.DELETE, pathParams, queryParams, requestBody,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Get asset file.
     * Streams the content of the specified file, with the appropriate HTTP
     * headers for etag, file size, mime type etc.
     * @param url containing at least the path, signature and containment (catalog_id, account_id, project_id or space_id) for the file
     * @param byteLimit If passed, indicates how many bytes of data is to be returned.
     * @param sizeLimit Returns 400 bad request if asset is larger than the value provided here. In MB.
     * @param flat If true folder structures are recursively flattened and the
     *     response is a list of files of all files in parent and child
     *     directories. The 'path' will show the resource full path from
     *     starting directory.
     * @param root If true is supplied in request URL the
     *     api will return relative to target container's root directory
     *     instead of assets directory. Supported for services. Also supported for
     *     account admin if targeting account directory.
     * @param inflate If true ALL other query params
     *     except the target are ignored. The file being retrieved must be an
     *     archive. If all checks pass the archive will be expanded to a temp
     *     location and the results will be returned as if flat=true was
     *     supplied. If the target archive has previously been inflated any existing
     *     inflate preview will be overwritten if the zip is newer. Otherwise the
     *     previous preview will be returned.
     * @param force Only used when inflate=true. Tells asset files to
     *     skip validation on whether the target is a zip. Inflate will be run
     *     regardless.
     * @return DataBuffer
     * @throws RestClientException if an error occurs while attempting to invoke the API
     * @see #get(String, String, String, String, String, Integer, Integer, String, Boolean, Boolean, Boolean, Boolean)
     */
    public Mono<DataBuffer> getFromUrl(String url,
                                       Integer byteLimit,
                                       Integer sizeLimit,
                                       Boolean flat,
                                       Boolean root,
                                       Boolean inflate,
                                       Boolean force) throws RestClientException {

        if (url != null) {
            UriComponents components;
            if (!url.startsWith("http")) {
                url = apiClient.getBasePath() + url;
            }
            components = UriComponentsBuilder.fromHttpUrl(url).build(true);
            String endpointPath = components.getPath();
            if (endpointPath != null && endpointPath.startsWith(BASE_API)) {
                String path = endpointPath.substring(BASE_API.length() + 1);
                MultiValueMap<String, String> queryParams = components.getQueryParams();
                String catalogId = null;
                if (queryParams.containsKey("catalog_id")) {
                    catalogId = queryParams.get("catalog_id").get(0);
                }
                String accountId = null;
                if (queryParams.containsKey("account_id")) {
                    accountId = queryParams.get("account_id").get(0);
                }
                String projectId = null;
                if (queryParams.containsKey("project_id")) {
                    projectId = queryParams.get("project_id").get(0);
                }
                String spaceId = null;
                if (queryParams.containsKey("space_id")) {
                    spaceId = queryParams.get("space_id").get(0);
                }
                String signature = null;
                if (queryParams.containsKey("signature")) {
                    signature = queryParams.get("signature").get(0);
                }
                return get(
                        path,
                        catalogId,
                        accountId,
                        projectId,
                        spaceId,
                        byteLimit,
                        sizeLimit,
                        signature,
                        flat,
                        root,
                        inflate,
                        force
                );
            }
        }
        return null;

    }

    /**
     * Get asset file.
     * Streams the content of the specified file, with the appropriate HTTP
     * headers for etag, file size, mime type etc. If the asset file is a
     * directory, response will be JSON listing the content of the directory. If
     * the asset is a file, response will be contents of the file. Requires viewer
     * permission. Service authentication is supported. Catalog assets require
     * service authentication. This endpoint supports authentication via signature
     * parameter.
     * @param path Asset file path
     * @param catalogId The catalog id the file is associated with. One of
     *     catalog, project, space or account id is required.
     * @param accountId The catalog id the file is associated with. One of
     *     catalog, project, space or account id is required.
     * @param projectId The project id the file is associated with. One of
     *     catalog, project, space or account id is required.
     * @param spaceId The space id the file is associated with. One of catalog,
     *     project, space or account id is required.
     * @param byteLimit If passed, indicates how many bytes of data is to be
     *     returned.
     * @param sizeLimit Returns 400 bad request if asset is larger than the value
     *     provided here. In MB.
     * @param signature Additional auth method. Signed string obtained by making
     *     pre-signed API request.
     * @param flat If true folder structures are recursively flattened and the
     *     response is a list of files of all files in parent and child
     *     directories. The 'path' will show the resource full path from
     *     starting directory.
     * @param root If true is supplied in request URL the
     *     api will return relative to target container's root directory
     *     instead of assets directory. Supported for services. Also supported for
     *     account admin if targeting account directory.
     * @param inflate If true ALL other query params
     *     except the target are ignored. The file being retrieved must be an
     *     archive. If all checks pass the archive will be expanded to a temp
     *     location and the results will be returned as if flat=true was
     *     supplied. If the target archive has previously been inflated any existing
     *     inflate preview will be overwritten if the zip is newer. Otherwise the
     *     previous preview will be returned.
     * @param force Only used when inflate=true. Tells asset files to
     *     skip validation on whether the target is a zip. Inflate will be run
     *     regardless.
     * @return DataBuffer
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     * @see #getSignedURL(String, Integer, String, String, String, String, String, String, Boolean, Boolean, String)
     */
    public Mono<DataBuffer> get(@NonNull String path,
                                String catalogId,
                                String accountId,
                                String projectId,
                                String spaceId,
                                Integer byteLimit,
                                Integer sizeLimit,
                                String signature,
                                Boolean flat,
                                Boolean root,
                                Boolean inflate,
                                Boolean force) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_id", accountId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "byte_limit", byteLimit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size_limit", sizeLimit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "signature", signature));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "flat", flat));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "root", root));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "inflate", inflate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "force", force));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        // Note: manually place the path, as it seems to be basically impossible to mix pre-encoded query parameters
        // (like 'signature') and path template replacements -- either the pre-encoded parameters end up double-encoded
        // or the path replacements are not replaced, or cause an exception to be thrown due to invalid characters
        ParameterizedTypeReference<DataBuffer> localVarReturnType = new ParameterizedTypeReference<DataBuffer>() {};
        return apiClient.invokeAPI(
                BASE_API + "/" + UriUtils.encodePathSegment(path, StandardCharsets.UTF_8), HttpMethod.GET, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType, true);

    }

    /**
     * Get asset file headers.
     * Returns ONLY the HTTP headers for etag, file size, mime type etc. without
     * streaming the file content. Requires viewer permission. Service
     * authentication is supported. Catalog assets require service authentication.
     * This endpoint supports authentication via signature parameter.
     * @param path Asset file path
     * @param catalogId The catalog id the file is associated with. One of
     *     catalog, project, space or account id is required.
     * @param accountId The catalog id the file is associated with. One of
     *     catalog, project, space or account id is required.
     * @param projectId The project id the file is associated with. One of
     *     catalog, project, space or account id is required.
     * @param spaceId The space id the file is associated with. One of catalog,
     *     project, space or account id is required.
     * @param signature Additional auth method. Signed URL obtained by making
     *     presigned API request.
     * @return {@code ResponseEntity<Void>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     * @see #getSignedURL(String, Integer, String, String, String, String, String, String, Boolean, Boolean, String)
     */
    public Mono<ResponseEntity<Void>> getHeaders(@NonNull String path,
                                                 String catalogId,
                                                 String accountId,
                                                 String projectId,
                                                 String spaceId,
                                                 String signature) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("path", path);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_id", accountId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "signature", signature));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        return apiClient.invokeAPI(
                BASE_API + "/{path}", HttpMethod.HEAD, pathParams, queryParams,
                null, headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType);

    }

    /**
     * Get a list of file paths.
     * Returns a list of file paths (similar to S3 listObjects) for the provided
     * project, catalog, space or account. Requires viewer or higher permission.
     * When requesting assets for a catalog only Basic auth is supported.
     * @param catalogId Request the files for this catalog id. One of catalog,
     *     project, space or account id is required.
     * @param accountId The catalog id the file is associated with. One of
     *     catalog, project, space or account id is required.
     * @param projectId Request the files for this project id. One of project,
     *     catalog, space or account id is required.
     * @param spaceId Request the files for this space id. One of project,
     *     catalog, space or account id is required.
     * @param limit Pagination param, limit number of resources returned.
     * @param offset Pagination param, resources returned wil be offset by this
     *     value.
     * @param flat If true folder structures are recursively flattened and the
     *     response is a list of files of all files in parent and child
     *     directories. The 'path' will show the resource full path from
     *     starting directory.
     * @param root If true is supplied in request URL the
     *     api will return relative to target container's root directory
     *     instead of assets directory. Supported for services. Also support for
     *     account admins if targeting account directory.
     * @return PaginatedAssetFileListResponse
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<PaginatedAssetFileListResponse> list(String catalogId,
                                                     String accountId,
                                                     String projectId,
                                                     String spaceId,
                                                     String limit,
                                                     String offset,
                                                     Boolean flat,
                                                     Boolean root) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_id", accountId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "flat", flat));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "root", root));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<PaginatedAssetFileListResponse> localVarReturnType = new ParameterizedTypeReference<PaginatedAssetFileListResponse>() {};
        return apiClient.invokeAPI(
                BASE_API, HttpMethod.GET, pathParams, queryParams, null,
                headerParams, cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

    /**
     * Put new asset file.
     * Uploads the bytes into the file with the provided file name using HTTP
     * multi-part format, creating a new file if missing, overriding if existing
     * (unless override=false). Adding catalog assets requires service
     * authentication or a signed url. Adding project or space assets accepts all
     * formats that grant editor access (user, signature or service). Adding to
     * accounts requires user with account admin access or service auth. This
     * endpoint supports authentication via signature parameter.
     * @param path Asset file path
     * @param catalogId The catalog id the file should be associated with. One of
     *     catalog, project, space or account id is required.
     * @param accountId The catalog id the file is associated with. One of
     *     catalog, project, space or account id is required.
     * @param projectId The project id the file should be associated with. One of
     *     catalog, project, space or account id is required.
     * @param spaceId The space id the file should be associated with. One of
     *     catalog, project, space or account id is required.
     * @param override Default true. If set to false will not overwrite file.
     * @param signature Additional auth method. Signed string obtained by making
     *     API request to signing endpoint.
     * @param inflate Root dir must be created. Will take supplied file and
     *     decompress into target directory tree. Inflate is only acceptable for
     *     project, space and catalog targets. If inflate is selected it will take
     *     precedence over any and all other params.
     * @param ensureDir Override utility. If true will ensure the directory
     *     specified in 'path' exists. 201 will be returned ig created,
     *     200 if already exists and 409 if it is present and not a directory.
     *     Will take precedence over other query params except 'inflate'
     * @param root If true is supplied in request URL the
     *     api will return relative to target container's root directory
     *     instead of assets directory. Supported for services. Also supported for
     *     account admin if targeting account directory.
     * @param body The body parameter
     * @return {@code ResponseEntity<StatusResponse>}
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     * @see #getSignedURL(String, Integer, String, String, String, String, String, String, Boolean, Boolean, String)
     */
    public ResponseEntity<StatusResponse> upload(@NonNull String path,
                                                 String catalogId,
                                                 String accountId,
                                                 String projectId,
                                                 String spaceId,
                                                 Boolean override,
                                                 String signature,
                                                 Boolean inflate,
                                                 Boolean ensureDir,
                                                 Boolean root,
                                                 File body)
            throws RestClientException,
                   IllegalArgumentException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("path", path);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_id", accountId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "override", override));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "signature", signature));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "inflate", inflate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "ensure_dir", ensureDir));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "root", root));

        final String[] localVarAccepts = {"application/json"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {"multipart/form-data"};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<StatusResponse> localVarReturnType = new ParameterizedTypeReference<StatusResponse>() {};
        return apiClient.invokeFileUploadAPI(
                BASE_API + "/{path}", HttpMethod.PUT,
                pathParams, queryParams, body, headerParams, cookieParams,
                formParams, localVarAccept, localVarContentType, localVarReturnType);

    }

    /**
     * Get auth signature.
     * Generate a signed URL that can be used to access specific API calls. Only
     * supports service auth with editor permission. A signed URL will be returned
     * in the response body as plain text. An encoded version of the same url will
     * be sent in the 'Location' header.
     * @param path The path to asset you wish to make signed url for.
     * @param expiresIn TTL in seconds.
     * @param catalogId The catalog id the file should be associated with. One of
     *     catalog, project, space or account id is required.
     * @param accountId The catalog id the file is associated with. One of
     *     catalog, project, space or account id is required.
     * @param projectId The project id the file should be associated with. One of
     *     catalog, project, space or account id is required.
     * @param spaceId The space id the file should be associated with. One of
     *     catalog, project, space or account id is required.
     * @param contentType Optional content type (to override the defaults of asset
     *     being requested)
     * @param contentDisposition Optional (to override the defaults) - must be
     *     URIEncoded as it can contain spaces if filename is used.
     * @param root Whether to access the path from root.
     * @param inflate Only useful for put. Will allow signed url to act as inflate
     *     request.
     * @param method Accepts 'get' (download) or 'put' (upload). (Defaults to
     *     'get' if not supplied)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke
     *     the API
     */
    public Mono<String> getSignedURL(@NonNull String path,
                                     @NonNull Integer expiresIn,
                                     String catalogId,
                                     String accountId,
                                     String projectId,
                                     String spaceId,
                                     String contentType,
                                     String contentDisposition,
                                     Boolean root,
                                     Boolean inflate,
                                     String method) throws RestClientException {

        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("path", path);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "catalog_id", catalogId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_id", accountId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "project_id", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "space_id", spaceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "content_type", contentType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "content_disposition", contentDisposition));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "expires_in", expiresIn));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "root", root));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "inflate", inflate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "method", method));

        final String[] localVarAccepts = {"application/json", "text/html", "text/plain"};
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(BASE_API + "/{path}/signed", HttpMethod.POST,
                pathParams, queryParams, null, headerParams,
                cookieParams, formParams, localVarAccept,
                localVarContentType, localVarReturnType);

    }

}
