# Changelog

## 0.1.0-alpha.2 (2026-06-25)

Full Changelog: [v0.1.0-alpha.1...v0.1.0-alpha.2](https://github.com/revenium/revenium-metering-java/compare/v0.1.0-alpha.1...v0.1.0-alpha.2)

### Features

* **api:** api update ([9414545](https://github.com/revenium/revenium-metering-java/commit/94145457257509cc35a7ab1b00238b261401570d))
* **api:** api update ([99780ed](https://github.com/revenium/revenium-metering-java/commit/99780edffff64fd243cae3f7eb9fa0f5c247e6b6))
* **api:** manual updates ([8063ff6](https://github.com/revenium/revenium-metering-java/commit/8063ff696a8e5c4aee1e78129a5d3105810dc3f6))
* **api:** manual updates ([fde7c81](https://github.com/revenium/revenium-metering-java/commit/fde7c817c3033faaea5c3d360aaa0752b1d59a77))
* **client:** add `HttpRequest#url()` method ([d521b8a](https://github.com/revenium/revenium-metering-java/commit/d521b8a87e1ccf8e8c88743aa5a9a81be5595fc1))
* **client:** allow configuring dispatcher executor service ([098d4e1](https://github.com/revenium/revenium-metering-java/commit/098d4e16d1ff3115ce11e49854a3d7eb95738b93))
* **client:** send `X-Stainless-Kotlin-Version` header ([1d269fb](https://github.com/revenium/revenium-metering-java/commit/1d269fb8b4eace62a90c66194b0f127143a062ec))


### Bug Fixes

* **client:** cancel okhttp call when future cancelled ([f9a0f61](https://github.com/revenium/revenium-metering-java/commit/f9a0f6113808e014a6ffc4ba68eea12050a8c64e))
* **client:** disallow coercion from float to int ([36f9033](https://github.com/revenium/revenium-metering-java/commit/36f903345f51b32267070d6eb5540b3ed73d4aa4))
* **client:** fully respect max retries ([7210f49](https://github.com/revenium/revenium-metering-java/commit/7210f494427b116689fb55f47289f4407a85ca6d))
* **client:** preserve time zone in lenient date-time parsing ([f42d8ff](https://github.com/revenium/revenium-metering-java/commit/f42d8ff916a6fe569c33d73c8c99e48c7485bb13))
* **client:** send retry count header for max retries 0 ([7210f49](https://github.com/revenium/revenium-metering-java/commit/7210f494427b116689fb55f47289f4407a85ca6d))
* date time deserialization leniency ([7d5866d](https://github.com/revenium/revenium-metering-java/commit/7d5866d4e7a009686bb9d0ca7d3bfb2d89d2e89a))


### Chores

* **ci:** upgrade `actions/setup-java` ([7471c8e](https://github.com/revenium/revenium-metering-java/commit/7471c8e94f9f475a0200940d31e1b10b361d7f45))
* **internal:** clean up maven repo artifact script and add html documentation to repo root ([2b22651](https://github.com/revenium/revenium-metering-java/commit/2b226513ddbc28f64e6cb55e4cf29ae929fb93b7))
* **internal:** codegen related update ([47340ab](https://github.com/revenium/revenium-metering-java/commit/47340abb008686f476b4030f9ea65c31e6da7a43))
* **internal:** codegen related update ([38bb9b4](https://github.com/revenium/revenium-metering-java/commit/38bb9b40479e341c2f0254bd67b573b22de6bb6d))
* **internal:** correct cache invalidation for `SKIP_MOCK_TESTS` ([b51f188](https://github.com/revenium/revenium-metering-java/commit/b51f188ab3cc7c7768ea255a6f561c30d0f18d3b))
* **internal:** depend on packages directly in example ([7210f49](https://github.com/revenium/revenium-metering-java/commit/7210f494427b116689fb55f47289f4407a85ca6d))
* **internal:** improve maven repo docs ([333d663](https://github.com/revenium/revenium-metering-java/commit/333d663094b653ac7459a94c9aa12eac18ddb1cc))
* **internal:** support uploading Maven repo artifacts to stainless package server ([f31fc84](https://github.com/revenium/revenium-metering-java/commit/f31fc845a1190399943fb8ca4faec5e08c22d1c5))
* **internal:** update `actions/checkout` version ([8504678](https://github.com/revenium/revenium-metering-java/commit/85046781f2e1cd4040d8180fd87b0683deb9cc51))
* **internal:** update maven repo doc to include authentication ([b14c237](https://github.com/revenium/revenium-metering-java/commit/b14c2371a57987c6dd94aef201b50a1ec05b003f))
* **security:** add gitleaks secret scanning (report-only) ([#3](https://github.com/revenium/revenium-metering-java/issues/3)) ([5282e8c](https://github.com/revenium/revenium-metering-java/commit/5282e8cb5cd631c13f579a229d04161ed1f297ea))
* test on Jackson 2.14.0 to avoid encountering FasterXML/jackson-databind[#3240](https://github.com/revenium/revenium-metering-java/issues/3240) in tests ([7d5866d](https://github.com/revenium/revenium-metering-java/commit/7d5866d4e7a009686bb9d0ca7d3bfb2d89d2e89a))


### Documentation

* mark no longer actively maintained — point to revenium.ai ([3cae70d](https://github.com/revenium/revenium-metering-java/commit/3cae70d0fbdebc89a81ed44802352e970dfae4d1))
* remove `$` for better copy-pasteabality ([7adc11c](https://github.com/revenium/revenium-metering-java/commit/7adc11c306024d778b5a250c071a5b1546fb724c))

## 0.1.0-alpha.1 (2025-11-19)

Full Changelog: [v0.0.1-alpha.0...v0.1.0-alpha.1](https://github.com/revenium/revenium-metering-java/compare/v0.0.1-alpha.0...v0.1.0-alpha.1)

### ⚠ BREAKING CHANGES

* **client:** change precision of some numeric types
* **client:** extract auto pagination to shared classes
* **client:** **Migration:** - If you were referencing the `AutoPager` class on a specific `*Page` or `*PageAsync` type, then you should instead reference the shared `AutoPager` and `AutoPagerAsync` types, under the `core` package
    - `AutoPagerAsync` now has different usage. You can call `.subscribe(...)` on the returned object instead to get called back each page item. You can also call `onCompleteFuture()` to get a future that completes when all items have been processed. Finally, you can call `.close()` on the returned object to stop auto-paginating early
    - If you were referencing `getNextPage` or `getNextPageParams`:
       - Swap to `nextPage()` and `nextPageParams()`
       - Note that these both now return non-optional types (use `hasNextPage()` before calling these, since they will throw if it's impossible to get another page)
* **client:** refactor exception structure and methods
* **client:** **Migration:** Previously you would access error JSON on an exception via `exception.error()._additionalProperties()`, which would return `Map<String, JsonValue>`. Now you would access this via `exception.body()`, which returns `JsonValue`. You should no longer assume that the returned error JSON is an object. You can check via `exception.body().asObject()`.

### Features

* **api:** api update ([42f0e32](https://github.com/revenium/revenium-metering-java/commit/42f0e320b253ec55c322e58349a740fa76305b61))
* **api:** api update ([da94b3f](https://github.com/revenium/revenium-metering-java/commit/da94b3f75aae57207371aec4ac52a5472035eae6))
* **api:** api update ([3baf00e](https://github.com/revenium/revenium-metering-java/commit/3baf00e8b83962abf8ed9151c649ddcbe69e579f))
* **api:** api update ([9b56130](https://github.com/revenium/revenium-metering-java/commit/9b561308023b964bf8fedd3176969585f8ef0dad))
* **api:** api update ([8ffd77b](https://github.com/revenium/revenium-metering-java/commit/8ffd77bd6955e7ed15f5212ee9874529cda19767))
* **api:** api update ([6c50343](https://github.com/revenium/revenium-metering-java/commit/6c503430134b5139035befea1289064bfb4e2348))
* **api:** api update ([83f4000](https://github.com/revenium/revenium-metering-java/commit/83f400093b8369b3ed062bf70f5e5418d6f6115d))
* **api:** api update ([46fda3c](https://github.com/revenium/revenium-metering-java/commit/46fda3c3f68f9489a16e9df9440daae5a6b2f4b2))
* **api:** api update ([f6c4b47](https://github.com/revenium/revenium-metering-java/commit/f6c4b477e94a7ec0bd6957ea70bddedd3960bfdd))
* **api:** api update ([a72d082](https://github.com/revenium/revenium-metering-java/commit/a72d082842cb041673be1b3e1c8cfc7bb70576b8))
* **api:** api update ([fc5251a](https://github.com/revenium/revenium-metering-java/commit/fc5251ac9324436ccccf5280029dd8e2cbc19247))
* **api:** api update ([8567d69](https://github.com/revenium/revenium-metering-java/commit/8567d6969ff845d3ec87ec9dd0276480e78edd61))
* **api:** api update ([5fba7e3](https://github.com/revenium/revenium-metering-java/commit/5fba7e32cf76a9ff770cd509049479f567e53e80))
* **api:** api update ([979578d](https://github.com/revenium/revenium-metering-java/commit/979578d0c904fb712f0e29394e20d716b4fe90c2))
* **api:** api update ([c15c887](https://github.com/revenium/revenium-metering-java/commit/c15c88700b7eff5bd71f1c57ca6ea07ea8ffdcb9))
* **api:** api update ([4e5dfaf](https://github.com/revenium/revenium-metering-java/commit/4e5dfafdaf43b5d7ae84d5598e01790121a0821a))
* **api:** api update ([6252b88](https://github.com/revenium/revenium-metering-java/commit/6252b88b5c0da3bac4b77324907084e54d21b81a))
* **api:** api update ([3c85759](https://github.com/revenium/revenium-metering-java/commit/3c85759eadd410afa19ecd95c8f9bb09294825c6))
* **api:** api update ([c1c9aca](https://github.com/revenium/revenium-metering-java/commit/c1c9aca093f8de9e734dedbd63ec41620bdbb763))
* **api:** api update ([cbc5ec8](https://github.com/revenium/revenium-metering-java/commit/cbc5ec8b8147c86c0e9e74b4025b04d476d57a26))
* **api:** api update ([d4c532e](https://github.com/revenium/revenium-metering-java/commit/d4c532e9641241ba9bcec1179c8524c34379c224))
* **api:** api update ([3239255](https://github.com/revenium/revenium-metering-java/commit/3239255bde5ca410bc98ec4aecee57cf9f9f61f8))
* **api:** api update ([ddb4733](https://github.com/revenium/revenium-metering-java/commit/ddb4733d57bcc5697caa9b80d1decc13d87682cb))
* **api:** api update ([baf16d6](https://github.com/revenium/revenium-metering-java/commit/baf16d699a3744d7e3b2affa58dc9bf3fc30f0b5))
* **api:** api update ([d68fc25](https://github.com/revenium/revenium-metering-java/commit/d68fc2518377c39a3b2e0c6f8ae38951c2cd9191))
* **api:** api update ([1df9bdc](https://github.com/revenium/revenium-metering-java/commit/1df9bdc7f2b89d50453269d011e5e3f20e9d790d))
* **api:** api update ([8879dd3](https://github.com/revenium/revenium-metering-java/commit/8879dd3ac0ff13468fe64218568a042035238a0b))
* **api:** api update ([9ea0ca6](https://github.com/revenium/revenium-metering-java/commit/9ea0ca6ab7a712451b53d7a10e46297d3da68572))
* **api:** api update ([315c5fa](https://github.com/revenium/revenium-metering-java/commit/315c5fa92c15828b4b08eb7b08ab61d2c927ae32))
* **api:** api update ([4034305](https://github.com/revenium/revenium-metering-java/commit/403430596aefe3c3ad50502100dd75b9a7819c4c))
* **api:** api update ([4f929fe](https://github.com/revenium/revenium-metering-java/commit/4f929fe88eccc18f0f57bebbbed9e18138f593ba))
* **api:** api update ([1240595](https://github.com/revenium/revenium-metering-java/commit/124059580411f324da4b25b4d7a7406fa3996c91))
* **api:** api update ([e122371](https://github.com/revenium/revenium-metering-java/commit/e122371510ec48250a42918f5a21f417b0366784))
* **api:** api update ([8585448](https://github.com/revenium/revenium-metering-java/commit/8585448ae3896f646de77f34bb6a3fa6143ca363))
* **api:** api update ([a131e16](https://github.com/revenium/revenium-metering-java/commit/a131e1684cbe6dd8850301bbd2fc2306203d0858))
* **api:** api update ([be5ee3f](https://github.com/revenium/revenium-metering-java/commit/be5ee3f174895f1bd25d029096893da1f4244b4a))
* **api:** api update ([0f2ff80](https://github.com/revenium/revenium-metering-java/commit/0f2ff80aa023fe2d96b1ea3090bf2f7af04227cd))
* **api:** api update ([faf7302](https://github.com/revenium/revenium-metering-java/commit/faf73021ee4d1f5c54ce31beef603cefc9022840))
* **api:** api update ([2a05b62](https://github.com/revenium/revenium-metering-java/commit/2a05b62f8248f9f32cb9110bc8d999eb40d62448))
* **api:** api update ([c7a805c](https://github.com/revenium/revenium-metering-java/commit/c7a805c5f15fe021123c1813b5189304e56e8f89))
* **api:** api update ([60ff9c2](https://github.com/revenium/revenium-metering-java/commit/60ff9c2cfa5169646c7a2ba302802b68104ff97d))
* **api:** api update ([d89cb0a](https://github.com/revenium/revenium-metering-java/commit/d89cb0a47389f5b59e2d6362e07d0dfb337dade6))
* **api:** api update ([9193c7a](https://github.com/revenium/revenium-metering-java/commit/9193c7a436a31cf08f672b8cbb98eb2bc7e0638f))
* **api:** api update ([1e6aaee](https://github.com/revenium/revenium-metering-java/commit/1e6aaee89c925127876e2697a661fe7b0094438d))
* **api:** api update ([7ca1139](https://github.com/revenium/revenium-metering-java/commit/7ca11399f4bf2ab0112c2df740ce5c74e33e6117))
* **api:** manual updates ([92cc0f7](https://github.com/revenium/revenium-metering-java/commit/92cc0f7eca6a931c2f95ad7c88e68edbfb16637d))
* **api:** manual updates ([1dc8078](https://github.com/revenium/revenium-metering-java/commit/1dc807813cffe75d00a8440ee8c21bd51f290426))
* **api:** manual updates ([4d661e6](https://github.com/revenium/revenium-metering-java/commit/4d661e664e6e700aad09b13c838d18fa2fb84d6a))
* **api:** manual updates ([7d157b7](https://github.com/revenium/revenium-metering-java/commit/7d157b731c8948388b50ab29375356792688f7f2))
* **api:** manual updates ([bf0957b](https://github.com/revenium/revenium-metering-java/commit/bf0957bbee2db9d0351979b3c9955ebeb452a6a9))
* **client:** add a `withOptions` method ([e924410](https://github.com/revenium/revenium-metering-java/commit/e92441035a39566255930ab1b6a9e1cdc5ac00b8))
* **client:** add enum validation method ([52868af](https://github.com/revenium/revenium-metering-java/commit/52868afdcc7a42dae4ea74f22a798ebd00be3c73))
* **client:** allow providing some params positionally ([3421138](https://github.com/revenium/revenium-metering-java/commit/3421138b22854022b5a36dfde34105494f05e273))
* **client:** expose request body setter and getter ([c4eb2f1](https://github.com/revenium/revenium-metering-java/commit/c4eb2f1123061d4f54888abf9605eb2eb02e207b))
* **client:** extract auto pagination to shared classes ([aea06af](https://github.com/revenium/revenium-metering-java/commit/aea06afb66ee9fe2f66108225fcd5471dd4b19ca))
* **client:** implement per-endpoint base URL support ([750e484](https://github.com/revenium/revenium-metering-java/commit/750e48463970f54a2ef6d3b4c3096396040c1294))
* **client:** make datetime deserialization more lenient ([811d3a5](https://github.com/revenium/revenium-metering-java/commit/811d3a55a8cf0ff81b5c8699f389216410a8e2a5))
* **client:** make union deserialization more robust ([52868af](https://github.com/revenium/revenium-metering-java/commit/52868afdcc7a42dae4ea74f22a798ebd00be3c73))
* **client:** support a lower jackson version ([fba90d3](https://github.com/revenium/revenium-metering-java/commit/fba90d3a50e672d93fe9e8e6dd6c430a5f477c75))
* **client:** support setting base URL via env var ([7714212](https://github.com/revenium/revenium-metering-java/commit/7714212889cbe3cd18b6a13a614f4eb756176829))
* **client:** throw on incompatible jackson version ([fba90d3](https://github.com/revenium/revenium-metering-java/commit/fba90d3a50e672d93fe9e8e6dd6c430a5f477c75))


### Bug Fixes

* **client:** bump max requests per host to max requests (5 -&gt; 64) ([760ea01](https://github.com/revenium/revenium-metering-java/commit/760ea0135f63937e2fe8e8e74b464f9d2fad7878))
* **client:** bump to better jackson version ([8327a08](https://github.com/revenium/revenium-metering-java/commit/8327a08763b5aaee4acefd895688c70d891e9b01))
* **client:** don't call `validate()` during deserialization if we don't have to ([7828f81](https://github.com/revenium/revenium-metering-java/commit/7828f81fec862da26cd6f250eaaf76bdceb9c47e))
* **client:** don't close client on `withOptions` usage when original is gc'd ([9dc1a90](https://github.com/revenium/revenium-metering-java/commit/9dc1a90c2c673c83bc57a56d538f1bee2e6bf8d2))
* **client:** ensure error handling always occurs ([7ba8c4b](https://github.com/revenium/revenium-metering-java/commit/7ba8c4b9bf50d467c901e0583d37b16560f43ec1))
* **client:** limit json deserialization coercion ([792812a](https://github.com/revenium/revenium-metering-java/commit/792812a29c51dc61d125adbe55ed0bcde3160c87))
* **client:** map deserialization bug ([915290f](https://github.com/revenium/revenium-metering-java/commit/915290fe076f11282d61e6226e759164315cd5eb))
* **client:** multi-value header serialization ([57ac7c3](https://github.com/revenium/revenium-metering-java/commit/57ac7c3f1dfe1eb00f787f558553e0aac1a9901f))
* **client:** remove `@MustBeClosed` for future returning methods ([b55e1bb](https://github.com/revenium/revenium-metering-java/commit/b55e1bb6a51fad0dfd1a35b1618dafe7cbf07d48))
* **client:** return `Optional&lt;T&gt;` instead of `Optional<? extends T>` ([51f82e5](https://github.com/revenium/revenium-metering-java/commit/51f82e5ac48c36608b0fa58be7231eed54717920))
* **client:** support kotlin 1.8 runtime ([ac2d06c](https://github.com/revenium/revenium-metering-java/commit/ac2d06c3fa06aea1f428fdedec81119a3d7a321c))


### Performance Improvements

* **client:** cached parsed type in `HttpResponseFor` ([a77ac6e](https://github.com/revenium/revenium-metering-java/commit/a77ac6e4763d1f300ee389ed017d4debfb56810c))
* **internal:** improve compilation+test speed ([a48c6f4](https://github.com/revenium/revenium-metering-java/commit/a48c6f4e438b217117693602605de818537646f1))


### Chores

* **ci:** add timeout thresholds for CI jobs ([20e13bc](https://github.com/revenium/revenium-metering-java/commit/20e13bc340ece2f0e3c1cc8d8c633c25fdfc9407))
* **ci:** enable for pull requests ([5468db2](https://github.com/revenium/revenium-metering-java/commit/5468db236cc7768b8f4c6c2dc80f597796f21839))
* **ci:** only run for pushes and fork pull requests ([c650f49](https://github.com/revenium/revenium-metering-java/commit/c650f494bbc6548be23fdb0b848a70c964a7ed6f))
* **ci:** only use depot for staging repos ([5d36b4e](https://github.com/revenium/revenium-metering-java/commit/5d36b4ec59f5b663a3ff869d8cb92dba0ac0e161))
* **client:** refactor exception structure and methods ([18dd796](https://github.com/revenium/revenium-metering-java/commit/18dd7966b36dac4ad76cbf0f72441495043180ac))
* **client:** remove unnecessary json state from some query param classes ([52868af](https://github.com/revenium/revenium-metering-java/commit/52868afdcc7a42dae4ea74f22a798ebd00be3c73))
* configure new SDK language ([9d5369f](https://github.com/revenium/revenium-metering-java/commit/9d5369fa3b1f5ef343e6f3332181effb865c1f5c))
* **docs:** grammar improvements ([8f3adeb](https://github.com/revenium/revenium-metering-java/commit/8f3adebdc87b84a9f9980235b482f8accfc4d7dd))
* **internal:** add invalid json deserialization tests ([52868af](https://github.com/revenium/revenium-metering-java/commit/52868afdcc7a42dae4ea74f22a798ebd00be3c73))
* **internal:** add json roundtripping tests ([52868af](https://github.com/revenium/revenium-metering-java/commit/52868afdcc7a42dae4ea74f22a798ebd00be3c73))
* **internal:** allow running specific example from cli ([dc29836](https://github.com/revenium/revenium-metering-java/commit/dc29836b44bcba6ebaeb6b71bb26dfa08b29fbe0))
* **internal:** codegen related update ([dbfc33d](https://github.com/revenium/revenium-metering-java/commit/dbfc33db3b4962daa2ae2be7846269f8d6f3d1c8))
* **internal:** codegen related update ([e8a274b](https://github.com/revenium/revenium-metering-java/commit/e8a274b5de532e84d02b3ce67d0b3b349fa7f4ec))
* **internal:** codegen related update ([bc3a3fd](https://github.com/revenium/revenium-metering-java/commit/bc3a3fd6811458a1a59629ebef11b702aab2bd59))
* **internal:** delete unused methods and annotations ([915290f](https://github.com/revenium/revenium-metering-java/commit/915290fe076f11282d61e6226e759164315cd5eb))
* **internal:** expand CI branch coverage ([e28186c](https://github.com/revenium/revenium-metering-java/commit/e28186c1a2efdcb74624a1836d0a82ad2ffc7f06))
* **internal:** fix example formatting ([fe470a8](https://github.com/revenium/revenium-metering-java/commit/fe470a8f8a41d4e3cf41397d000d4c84ce9feebe))
* **internal:** generate more tests ([cd0b8c7](https://github.com/revenium/revenium-metering-java/commit/cd0b8c78b9247413c27207ba719469c1ef36a81c))
* **internal:** java 17 -&gt; 21 on ci ([905f30b](https://github.com/revenium/revenium-metering-java/commit/905f30bd65985b9196247b9a51870f70e26d8610))
* **internal:** make multipart assertions more robust ([24b267c](https://github.com/revenium/revenium-metering-java/commit/24b267c0ed566528644f6094c1c08213b714e336))
* **internal:** reduce CI branch coverage ([95244a9](https://github.com/revenium/revenium-metering-java/commit/95244a9659314ffc8cc811740ff1318b9fbbef70))
* **internal:** reformat some tests ([cd0b8c7](https://github.com/revenium/revenium-metering-java/commit/cd0b8c78b9247413c27207ba719469c1ef36a81c))
* **internal:** remove flaky `-Xbackend-threads=0` option ([b762626](https://github.com/revenium/revenium-metering-java/commit/b762626a4f9a735c3d8525df859e7465582fb47a))
* **internal:** remove unnecessary `assertNotNull` calls ([24b267c](https://github.com/revenium/revenium-metering-java/commit/24b267c0ed566528644f6094c1c08213b714e336))
* **internal:** remove unnecessary import ([616b918](https://github.com/revenium/revenium-metering-java/commit/616b918cf7d745502baa7e83df2fa9d58051bfe7))
* **internal:** swap from `getNullable` to `getOptional` ([f39b612](https://github.com/revenium/revenium-metering-java/commit/f39b6128168367a462c933b4c54be112cf5fc1e7))
* **internal:** update java toolchain ([f19c9a7](https://github.com/revenium/revenium-metering-java/commit/f19c9a7c4f366c04610f5a8e1c048a0a5b3b4944))
* **tests:** improve enum examples ([cc0453c](https://github.com/revenium/revenium-metering-java/commit/cc0453ca4d31e53603ab10c22c2b4a25ac0d8a7a))
* update SDK settings ([f86229b](https://github.com/revenium/revenium-metering-java/commit/f86229b8a749f1fe545f2aae19570d4f47722c70))


### Documentation

* add `build` method comments ([e836f2b](https://github.com/revenium/revenium-metering-java/commit/e836f2b9321bf7bb001ab4b40cf636872f32ce19))
* add comments to `JsonField` classes ([51f82e5](https://github.com/revenium/revenium-metering-java/commit/51f82e5ac48c36608b0fa58be7231eed54717920))
* **client:** update jackson compat error message ([15c830d](https://github.com/revenium/revenium-metering-java/commit/15c830d08d9287f4039cb006986bd356130303d6))
* document how to forcibly omit required field ([d3c764b](https://github.com/revenium/revenium-metering-java/commit/d3c764b9086644f1e8f7dd3eef80c1a8e19f232b))
* explain http client customization ([fa4f243](https://github.com/revenium/revenium-metering-java/commit/fa4f243032bbedfdf1bddc5e7e6575f6ad3c7226))
* explain jackson compat in readme ([d9d4a83](https://github.com/revenium/revenium-metering-java/commit/d9d4a83b7a1fcc7aa2177f598f00260805119e90))
* minor readme tweak ([f896e1d](https://github.com/revenium/revenium-metering-java/commit/f896e1dba406789f9fe32be41edc7564b285c21c))
* refine comments on multipart params ([24b267c](https://github.com/revenium/revenium-metering-java/commit/24b267c0ed566528644f6094c1c08213b714e336))
* remove or fix invalid readme examples ([4b480d9](https://github.com/revenium/revenium-metering-java/commit/4b480d99aa9fad191a69721d374a6c366dc85bb8))
* swap examples used in readme ([d3c764b](https://github.com/revenium/revenium-metering-java/commit/d3c764b9086644f1e8f7dd3eef80c1a8e19f232b))
* update documentation links to be more uniform ([790a017](https://github.com/revenium/revenium-metering-java/commit/790a017b70b11467440d34e50531121ad0bf0cf4))
* update readme exception docs ([c4725b3](https://github.com/revenium/revenium-metering-java/commit/c4725b354e447e7934e67034374dd44d4c6caaaa))


### Refactors

* **client:** change precision of some numeric types ([de13458](https://github.com/revenium/revenium-metering-java/commit/de134581062a4b2a0d7d3bfc7b8a0d968d781598))
* **internal:** minor `ClientOptionsTest` change ([cde664a](https://github.com/revenium/revenium-metering-java/commit/cde664a4e8f50b9e719744fe016edf22de37841f))
